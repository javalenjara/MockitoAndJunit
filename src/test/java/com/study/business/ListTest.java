package com.study.business;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    public void mockingListSizeMethod() {
        List mockedList = mock(List.class);
        when(mockedList.size()).thenReturn(2);
        assertEquals(2, mockedList.size());
    }

    @Test
    public void mockingListSizeMethod_ReturnMultipleValues() {
        List mockedList = mock(List.class);
        when(mockedList.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, mockedList.size());
        assertEquals(3, mockedList.size());
    }

    @Test
    public void mockingListGetMethod() {
        List mockedList = mock(List.class);
        when(mockedList.get(0)).thenReturn("anyString");

        assertEquals("anyString", mockedList.get(0));
        assertEquals(null, mockedList.get(1));
    }

    @Test
    public void mockingListGetMethod_WithArgumentMatchers() {
        List mockedList = mock(List.class);
        when(mockedList.get(anyInt())).thenReturn("anyString");

        assertEquals("anyString", mockedList.get(0));
        assertEquals("anyString", mockedList.get(1));
    }

    @Test (expected = RuntimeException.class)
    public void mockingListGetMethod_ThrowingException() {
        List mockedList = mock(List.class);
        when(mockedList.get(anyInt())).thenThrow(new RuntimeException("Something went wrong."));

        mockedList.get(0);
    }
}
