package winarto.todolist;

import winarto.todolist.repository.TodoListRepositoryImpl;
import winarto.todolist.service.TodoListServiceImpl;
import winarto.todolist.view.TodoListViewImpl;

public class App {
    public static void main(String[] args) {
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        TodoListServiceImpl todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListViewImpl todoListView = new TodoListViewImpl(todoListService);

        todoListView.show();
    }
}
