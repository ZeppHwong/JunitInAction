package com.example.junit;

import com.example.junit.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ParameterizedTest {
    private double expectValue;
    private double value1;
    private double value2;

    @Parameterized.Parameters
    public static Collection<Integer[]> getTestParameters(){
        return Arrays.asList(new Integer[][]{
                {2, 1, 1},
                {3, 2, 1},
                {4, 3, 1}
        });
    }

    public ParameterizedTest(double expectValue, double value1, double value2){
        this.expectValue = expectValue;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Test
    public void sum(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(expectValue, calculator.add(value1, value2), 0);
    }
}
