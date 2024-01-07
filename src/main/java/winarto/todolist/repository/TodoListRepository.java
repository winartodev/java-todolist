package winarto.todolist.repository;

import winarto.todolist.data.TodoList;

import java.util.List;

public interface TodoListRepository {
    List<TodoList> getTodoList();
    TodoList getTodoListByID(int id);
    void insertTodoList(TodoList todoList);
    void removeTodoListByID(int id);
}
