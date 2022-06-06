package com.study.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class MockingStaticMethodTest {

    //Specific runner class needs to be used when combining static mocks
    //Initialize the static class in this case UtilitiClass.class
    //Mock

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void mockingStaticMethodTest() {
        List<Integer> stats = Arrays.asList(1, 2, 3);

        when(dependency.retrieveAllStats()).thenReturn(stats);

        PowerMockito.mockStatic(UtilityClass.class);

        when(UtilityClass.staticMethod(6)).thenReturn(150);

        int result = systemUnderTest.methodCallingAStaticMethod();

        assertEquals(150, result);
        PowerMockito.verifyStatic();
        UtilityClass.staticMethod(6);

    }

}