package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralTest {

    private RomanNumeral romanNumeral;

    @BeforeEach
    void setUp() {
        romanNumeral = new RomanNumeral();
    }

    @Test
    void it_should_convert_to_roman_numbers() {
        assertEquals("I", romanNumeral.convert(1));
        assertEquals("II", romanNumeral.convert(2));
        assertEquals("III", romanNumeral.convert(3));
        assertEquals("IV", romanNumeral.convert(4));
        assertEquals("V", romanNumeral.convert(5));
        assertEquals("VI", romanNumeral.convert(6));
        assertEquals("VII", romanNumeral.convert(7));
        assertEquals("VIII", romanNumeral.convert(8));
        assertEquals("IX", romanNumeral.convert(9));
        assertEquals("X", romanNumeral.convert(10));
        assertEquals("XI", romanNumeral.convert(11));
        assertEquals("XII", romanNumeral.convert(12));
        assertEquals("XIII", romanNumeral.convert(13));
        assertEquals("XIV", romanNumeral.convert(14));
        assertEquals("XV", romanNumeral.convert(15));
        assertEquals("XVI", romanNumeral.convert(16));
        assertEquals("XVII", romanNumeral.convert(17));
        assertEquals("XX", romanNumeral.convert(20));
        assertEquals("XXI", romanNumeral.convert(21));
        assertEquals("XXX", romanNumeral.convert(30));
        assertEquals("XXXI", romanNumeral.convert(31));
        assertEquals("XXXIV", romanNumeral.convert(34));
        assertEquals("XXXVIII", romanNumeral.convert(38));
        assertEquals("XL", romanNumeral.convert(40));
        assertEquals("L", romanNumeral.convert(50));
        assertEquals("LX", romanNumeral.convert(60));
        assertEquals("XC", romanNumeral.convert(90));
        assertEquals("XCV", romanNumeral.convert(95));
        assertEquals("C", romanNumeral.convert(100));
        assertEquals("CD", romanNumeral.convert(400));
        assertEquals("D", romanNumeral.convert(500));
        assertEquals("CM", romanNumeral.convert(900));
        assertEquals("M", romanNumeral.convert(1000));
        assertEquals("MMXIX", romanNumeral.convert(2019));
        assertEquals("CCXCIV", romanNumeral.convert(294));
        assertEquals("LXXX", romanNumeral.convert(80));
        assertEquals("XXIX", romanNumeral.convert(29));
    }

    //@Test
    //void it_should_convert_four() {
    //    assertEquals("IV", new RomanNumeral().convert(4));
    //}

    //@Test
    //void it_should_convert_nine() {
    //    assertEquals("IX", new RomanNumeral().convert(9));
    //}

    //@Test
    //void it_should_convert_thirtyFour() {
    //    assertEquals("XXXIV", new RomanNumeral().convert(34));
    //}

}
