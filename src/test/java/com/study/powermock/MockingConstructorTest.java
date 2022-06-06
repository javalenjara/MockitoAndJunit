package com.study.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
public class MockingConstructorTest {

    //Prepare the class for test: SystemUnderTest.class, porque es la que utiliza el constructor
    //override the constructor

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Mock
    ArrayList mockList;

    @Test
    public void mockingConstructorTest() throws Exception {
        List<Integer> stats = Arrays.asList(1, 2, 3);

        when(mockList.size()).thenReturn(5);

        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);

        int size = systemUnderTest.methodUsingAnArrayListConstructor();

        assertEquals(5, size);
    }

}