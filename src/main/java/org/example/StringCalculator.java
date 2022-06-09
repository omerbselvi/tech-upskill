package org.example;

import java.util.ArrayList;

public class StringCalculator {

    private final static String TEMPLATE = "//";
    private final static String DELIMITER = "[,\n]";
    private final static Integer MAX_RANGE = 1000;

    public Integer add(String numbers) {
        if (numbers.startsWith(TEMPLATE)) {
            numbers = getNumbers(numbers);
        }
        if (numbers.equals("")) return 0;

        String[] strArray = numbers.split(DELIMITER);
        ArrayList<Integer> negatives = new ArrayList<>();

        int sum = calculateSum(strArray, negatives);
        negativeNumberExist(negatives);

        return sum;
    }

    private String getNumbers(String numbers) {
        numbers = normalizeNumbers(numbers);
        numbers = getSecondPart(numbers);
        return numbers;
    }

    private String getSecondPart(String numbers) {
        int newLine = numbers.indexOf("\n");
        numbers = numbers.substring(newLine + 1);
        return numbers;
    }

    private int calculateSum(String[] strArray, ArrayList<Integer> negatives) {
        int sum = 0;
        for (String numberStr : strArray) {
            int number = Integer.parseInt(numberStr);
            addNegativeNumberToList(negatives, number);
            if (outOfRangeNumberExist(number)) continue;
            sum += number;
        }
        return sum;
    }

    private boolean outOfRangeNumberExist(int number) {
        return number > MAX_RANGE;
    }

    private void negativeNumberExist(ArrayList<Integer> negatives) {
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not alloved:" + negatives);
        }
    }

    private String normalizeNumbers(String numbers) {
        String delimiter;
        int firstBracketIndex = numbers.indexOf('[');
        int secondBracketIndex = numbers.indexOf(']');
        if (firstBracketIndex > 0 && secondBracketIndex > 0) {
            delimiter = numbers.substring(firstBracketIndex + 1, secondBracketIndex);
            numbers = numbers.replace(delimiter, ",");
            String firstPart = getFirstPart(numbers);
            numbers = replaceMultipleDelimiters(numbers, firstPart);
        } else {
            delimiter = String.valueOf(numbers.charAt(2));
        }
        numbers = numbers.replace(delimiter, ",");
        return numbers;
    }

    private String replaceMultipleDelimiters(String numbers, String firstPart) {
        firstPart = firstPart.replace("//", "");
        firstPart = firstPart.replace("[", "");
        firstPart = firstPart.replace("]", "");
        for (char ch : firstPart.toCharArray()) {
            numbers = numbers.replace(String.valueOf(ch), ",");
        }
        return numbers;
    }

    private String getFirstPart(String numbers) {
        int newLine = numbers.indexOf("\n");
        return numbers.substring(0, newLine);
    }

    private void addNegativeNumberToList(ArrayList<Integer> negatives, int number) {
        if (number < 0) {
            negatives.add(number);
        }
    }
}
