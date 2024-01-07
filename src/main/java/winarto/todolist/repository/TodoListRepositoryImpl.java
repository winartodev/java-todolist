package winarto.todolist.repository;

import winarto.todolist.data.TodoList;

import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryImpl implements TodoListRepository {

    private final List<TodoList> todoLists = new ArrayList<>();

    public TodoListRepositoryImpl() {

    }

    @Override
    public List<TodoList> getTodoList() {
        return todoLists;
    }

    @Override
    public TodoList getTodoListByID(int id) {
        if (!todoLists.isEmpty() && id < todoLists.size()) {
            return todoLists.get(id);
        } else {
            return null;
        }
    }

    @Override
    public void insertTodoList(TodoList todoList) {
        todoLists.add(todoList);
    }

    @Override
    public void removeTodoListByID(int id) {
        todoLists.remove(id);
    }
}
