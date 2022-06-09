package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void emptyCheck() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void singleNumber() {
        assertEquals(4, calculator.add("4"));
    }

    @Test
    void twoNumbers() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    void multipleNumbers() {
        assertEquals(45, calculator.add("1,2,3,4,5,6,7,8,9"));
    }

    @Test
    void newLineSeparator() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void newCustomSeparator() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    void andSeparator() {
        assertEquals(6, calculator.add("//&\n1&2&3"));
    }

    @Test
    void negativesNotAllowed() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new StringCalculator().add("1,-2,-3,6"));
        assertEquals("negatives not alloved:[-2, -3]", exception.getMessage());
    }

    @Test
    void emptyCheckWithCustomSeperator() {
        assertEquals(0, calculator.add("//&\n"));
    }

    @Test
    void checkNumberBiggerThanOneThousandAndOne() {
        assertEquals(1003, calculator.add("//&\n1&2&1000&1001&00"));
    }

    @Test
    void checkArbitraryLengthSeperatorExist() {
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }

    @Test
    void multipleSingleCharacterDelimeter() {
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }
}