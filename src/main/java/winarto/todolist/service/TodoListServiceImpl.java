package winarto.todolist.service;

import winarto.todolist.data.TodoList;
import winarto.todolist.error.Errors;
import winarto.todolist.repository.TodoListRepository;

import java.util.List;

public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public List<TodoList> getTodoList() {
        List<TodoList> todoList = todoListRepository.getTodoList();
        if (todoList != null) {
            return todoList;
        } else {
            System.out.println(Errors.TODOLIST_EMPTY);
            return null;
        }
    }

    @Override
    public TodoList getTodoListByID(int id) {
        TodoList todoList = todoListRepository.getTodoListByID(id);
        if (todoList != null) {
            return todoList;
        } else {
            System.out.printf((Errors.TODOLIST_NOT_FOUND_WITH_INDEX) + "%n\n", id);
            return null;
        }
    }

    @Override
    public void insertTodoList(TodoList todoList) {
        todoListRepository.insertTodoList(todoList);
    }

    @Override
    public void removeTodoListByID(int id) {
        TodoList todoList = getTodoListByID(id);
        if (todoList != null) {
            todoListRepository.removeTodoListByID(id);
        }
    }
}
