package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeral {

    LinkedHashMap<Integer, String> arabicToRoman = new LinkedHashMap<>();

    public RomanNumeral() {
        putRomanNumbers();
    }

    private void putRomanNumbers() {
        this.arabicToRoman.put(1000, "M");
        this.arabicToRoman.put(900, "CM");
        this.arabicToRoman.put(500, "D");
        this.arabicToRoman.put(400, "CD");
        this.arabicToRoman.put(100, "C");
        this.arabicToRoman.put(90, "XC");
        this.arabicToRoman.put(50, "L");
        this.arabicToRoman.put(40, "XL");
        this.arabicToRoman.put(10, "X");
        this.arabicToRoman.put(9, "IX");
        this.arabicToRoman.put(5, "V");
        this.arabicToRoman.put(4, "IV");
        this.arabicToRoman.put(1, "I");
    }

    public String convert(int number) {
        String romanNumber = "";

        for (Map.Entry<Integer, String> entry : arabicToRoman.entrySet()) {
            while (number >= entry.getKey()) {
                romanNumber = romanNumber + entry.getValue();
                number = number - entry.getKey();
            }
        }
        return romanNumber;
    }
}
