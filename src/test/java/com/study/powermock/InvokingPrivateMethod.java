package com.study.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class InvokingPrivateMethod {

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void mockingStaticMethodTest() throws Exception {
        List<Integer> stats = Arrays.asList(1, 2, 3);

        when(dependency.retrieveAllStats()).thenReturn(stats);

        long result = Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");

        assertEquals(6, result);

    }
}
