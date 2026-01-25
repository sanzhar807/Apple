package calculator;

import org.example.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test
//    void sumTest(){
//
//        Assertions.assertEquals(4.00,calculator.sum(2,2));
//
//    }

    void sumTest(){

        Assertions.assertEquals(1,calculator.divide(2,2));

    }
}
