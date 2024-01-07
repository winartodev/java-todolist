package winarto.todolist.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.junit.jupiter.MockitoExtension;
import winarto.todolist.data.TodoList;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class TodoListRepositoryTest {
    private TodoListRepositoryImpl todoListRepository;

    @BeforeEach
    public void setUp() {
        todoListRepository = new TodoListRepositoryImpl();
    }

    @Test
    public void testGetTodoListSuccess() {
        Assertions.assertEquals(0, todoListRepository.getTodoList().size());

        todoListRepository.insertTodoList(new TodoList("Todo List 1"));
        todoListRepository.insertTodoList(new TodoList("Todo List 2"));

        Assertions.assertEquals(2, todoListRepository.getTodoList().size());
    }

    @Test
    public void testGetTodoListByIDSuccess() {
        Assertions.assertNull(todoListRepository.getTodoListByID(0));

        TodoList todoList1 = new TodoList("Todo List 1");
        TodoList todoList2 = new TodoList("Todo List 2");

        todoListRepository.insertTodoList(todoList1);
        todoListRepository.insertTodoList(todoList2);

        Assertions.assertEquals(todoList2, todoListRepository.getTodoListByID(1));
    }

    @Test
    public void testInsertTodoList() {
        TodoList todoList1 = new TodoList("Todo List 1");

        todoListRepository.insertTodoList(todoList1);

        Assertions.assertEquals(1, todoListRepository.getTodoList().size());
        Assertions.assertEquals(todoList1, todoListRepository.getTodoListByID(0));
    }

    @Test
    public void testRemoveTodolistByID() {
        TodoList todoList1 = new TodoList("Todo List 1");
        TodoList todoList2 = new TodoList("Todo List 2");

        todoListRepository.insertTodoList(todoList1);
        todoListRepository.insertTodoList(todoList2);

        Assertions.assertEquals(2, todoListRepository.getTodoList().size());
        Assertions.assertEquals(todoList1, todoListRepository.getTodoListByID(0));

        todoListRepository.removeTodoListByID(0);

        Assertions.assertEquals(1, todoListRepository.getTodoList().size());
        Assertions.assertEquals(todoList2, todoListRepository.getTodoListByID(0));
    }
}
