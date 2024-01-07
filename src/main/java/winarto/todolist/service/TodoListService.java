package winarto.todolist.service;

import winarto.todolist.data.TodoList;

import java.util.List;

public interface TodoListService {
    List<TodoList> getTodoList();
    TodoList getTodoListByID(int id);
    void insertTodoList(TodoList todoList);
    void removeTodoListByID(int id);
}
