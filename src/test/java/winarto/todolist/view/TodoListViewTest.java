package winarto.todolist.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import winarto.todolist.data.TodoList;
import winarto.todolist.service.TodoListService;

import java.util.ArrayList;
import java.util.List;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class TodoListViewTest {
    @Mock
    private TodoListService todoListService;

    private TodoListViewImpl todoListView;

    @BeforeEach
    public void setUp() {
        todoListView = new TodoListViewImpl(todoListService);
    }

    @Test
    public void testGetTodoList() {
        List<TodoList> data = new ArrayList<>();
        data.add(new TodoList("Todo List Data 1"));

        Mockito.when(todoListService.getTodoList()).thenReturn(data);

        todoListView.getTodoList(null);

        Mockito.verify(todoListService, Mockito.times(1)).getTodoList();
    }

    @Test
    public void testGetTodoListByID() {
        TodoList data = new TodoList("Todo List Data 1");

        Mockito.when(todoListService.getTodoListByID(0)).thenReturn(data);

        todoListView.getTodoList(0);

        Mockito.verify(todoListService, Mockito.times(1)).getTodoListByID(0);
    }

    @Test
    public void testInsertTodoList() {
        TodoList data = new TodoList("Todo List Data 1");

        todoListView.insertTodoList("Todo List Data 1");

        Mockito.verify(todoListService, Mockito.times(1)).insertTodoList(data);
    }

    @Test
    public void testInsertTodoListWithBlankDescription() {
        todoListView.insertTodoList("");
    }

    @Test
    public void testRemoveTodoList() {
        todoListView.removeTodoList(1);

        Mockito.verify(todoListService, Mockito.times(1)).removeTodoListByID(0);
    }

    @Test
    public void testRemoveTodoListIDIsNull() {
        todoListView.removeTodoList(null);
    }
}
