package com.study.mockito;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;

public class SpyTest {

    @Test public void spyTest() {
        List arrayListSpy = spy(ArrayList.class);
        stub(arrayListSpy.size()).toReturn(5);
        assertEquals(5, arrayListSpy.size());
        arrayListSpy.add("Dummy");
    }
}
