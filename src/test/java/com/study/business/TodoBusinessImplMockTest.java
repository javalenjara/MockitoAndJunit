package com.study.business;

import com.study.data.api.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockTest {

    @Test
    public void testretrieveTodosRelatedToSpring_usingMocks() {
        TodoService mockTodoService = mock(TodoService.class);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
        List<String> todos = Arrays.asList("Study Spring MVC", "Study Mockito", "Study Spring Security",
            "Go to the supermarket");
        when(mockTodoService.retrieveTodos("User")).thenReturn(todos);
        final List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("User");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void testretrieveTodosRelatedToSpring_withEmptyList() {
        TodoService mockTodoService = mock(TodoService.class);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
        when(mockTodoService.retrieveTodos("User")).thenReturn(Collections.emptyList());
        final List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("User");
        assertEquals(0, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingMockitoBDD() {
        //Given
        TodoService mockTodoService = mock(TodoService.class);
        List<String> todos = Arrays.asList("Study Spring MVC", "Study Mockito", "Study Spring Security",
            "Go to the supermarket");
        when(mockTodoService.retrieveTodos("User")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
        //When
        final List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("User");
        //Then
        assertEquals(2, filteredTodos.size());
    }
}