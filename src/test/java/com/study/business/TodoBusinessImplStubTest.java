package com.study.business;

import com.study.data.api.TodoService;
import com.study.data.api.TodoServiceStub;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TodoBusinessImplStubTest {

    @Test
    public void testretrieveTodosRelatedToSpring_usingStubs() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        final List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("User");
        assertEquals(2, filteredTodos.size());
        assertArrayEquals(Arrays.asList("Study Spring MVC", "Study Spring Security").toArray(), filteredTodos.toArray());
    }
}