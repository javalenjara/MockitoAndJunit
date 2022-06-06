package com.study.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService{
    @Override
    public List<String> retrieveTodos(String user){
        return Arrays.asList("Study Spring MVC", "Study Mockito", "Study Spring Security", "Go to the supermarket");
    }
}
