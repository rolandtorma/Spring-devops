package com.example.sum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest{

    private calculator calculator = new calculator();

    @Test
    public void testSum(){
        assertEquals(5, calculator.sum(2, 3));
    }

}