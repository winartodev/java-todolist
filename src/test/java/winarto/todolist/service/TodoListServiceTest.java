package winarto.todolist.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import winarto.todolist.data.TodoList;
import winarto.todolist.repository.TodoListRepository;

import java.util.ArrayList;
import java.util.List;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class TodoListServiceTest {
    @Mock
    private TodoListRepository todoListRepository;

    private TodoListServiceImpl todoListService;

    @BeforeEach
    public void setUp() {
        todoListService = new TodoListServiceImpl(todoListRepository);
    }

    @Test
    public void testGetTodoListSuccess() {
        List<TodoList> data = new ArrayList<TodoList>();
        data.add(new TodoList("Todo List 1"));

        Mockito.when(todoListRepository.getTodoList()).thenReturn(data);

        List<TodoList> actual = todoListService.getTodoList();

        Mockito.verify(todoListRepository, Mockito.times(1)).getTodoList();
        Assertions.assertEquals(data, actual);
    }

    @Test
    public void testGetTodoListEmptyData() {
        Mockito.when(todoListRepository.getTodoList()).thenReturn(null);

        List<TodoList> actual = todoListService.getTodoList();

        Mockito.verify(todoListRepository, Mockito.times(1)).getTodoList();
        Assertions.assertNull(actual);
    }

    @Test
    public void testGetTodoListByIDSuccess() {
        TodoList data = new TodoList("Todo List 1");
        Mockito.when(todoListRepository.getTodoListByID(0)).thenReturn(data);

        TodoList actual = todoListService.getTodoListByID(0);

        Mockito.verify(todoListRepository, Mockito.times(1)).getTodoListByID(0);
        Assertions.assertEquals(data, actual);
    }

    @Test
    public void testGetTodoListByIDNotFound() {
        Mockito.when(todoListRepository.getTodoListByID(0)).thenReturn(null);

        TodoList actual = todoListService.getTodoListByID(0);

        Mockito.verify(todoListRepository, Mockito.times(1)).getTodoListByID(0);
        Assertions.assertNull(actual);
    }

    @Test
    public void testInsertTodoList() {
        TodoList data = new TodoList("Todo List Data 1");

        todoListService.insertTodoList(data);

        Mockito.verify(todoListRepository, Mockito.times(1)).insertTodoList(data);
    }

    @Test
    public void testRemoveTodoListByID() {
        TodoList data = new TodoList("Todo List Data 1");
        Mockito.when(todoListRepository.getTodoListByID(0)).thenReturn(data);

        todoListService.removeTodoListByID(0);

        Mockito.verify(todoListRepository, Mockito.times(1)).getTodoListByID(0);
        Mockito.verify(todoListRepository, Mockito.times(1)).removeTodoListByID(0);
    }
}
