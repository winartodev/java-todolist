package winarto.todolist.view;

import winarto.todolist.data.TodoList;
import winarto.todolist.error.Errors;
import winarto.todolist.service.TodoListService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoListViewImpl {
    private TodoListService todoListService;

    public TodoListViewImpl(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void getTodoList(Integer id) {
        List<TodoList> todoLists = new ArrayList<>();

        if (id != null) {
            TodoList data = todoListService.getTodoListByID(id);
            if (data != null) {
                todoLists.add(data);
            }
        } else {
            var data = todoListService.getTodoList();
            if (data != null) {
                todoLists = data;
            }
        }

        int number = 1;
        System.out.println("List Of Todo:");
        for (var todoList : todoLists) {
            System.out.println(number + "." + " " + todoList.getDescription());
        }
    }

    public void insertTodoList(String description) {
        if (description.isBlank() || description.isEmpty()) {
            System.out.println(Errors.TODOLIST_DESCRIPTION_FIELD_IS_EMPTY);
            return;
        }
        TodoList todoList = new TodoList(description);

        todoListService.insertTodoList(todoList);
    }

    public void removeTodoList(Integer id) {
        if (id == null) {
            System.out.println(Errors.TODOLIST_ID_FIELD_IS_EMPTY);
            return;
        }

        if (id > 0) {
            id -= 1;
        }

        todoListService.removeTodoListByID(id);
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Show Todo List");
            System.out.println("2. Show Todo by ID");
            System.out.println("3. Add Todo");
            System.out.println("4. Remove Todo");
            System.out.println("q. Quit");

            System.out.print("Enter Input: ");
            String input = scanner.next();
            Integer id = null;
            String description = null;

            switch (input) {
                case "1":
                    getTodoList(null);
                    break;
                case "2":
                    System.out.print("Masukkan id: ");
                    id = scanner.nextInt();
                    getTodoList(id);
                    break;
                case "3":
                    System.out.print("Masukkan deskripsi: ");
                    description = scanner.next();
                    insertTodoList(description);
                    break;
                case "4":
                    System.out.print("Masukkan id: ");
                    id = scanner.nextInt();
                    removeTodoList(id);
                    break;
                case "q":
                    System.exit(0);
                    break;
            }
        }
    }
}
