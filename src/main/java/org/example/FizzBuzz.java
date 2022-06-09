package org.example;

public class FizzBuzz {

    public String fizzBuzz(Integer number) {
        if (number <0 || number > 100){
            throw new IllegalArgumentException();
        }
        if (isDivisibleBy(number, 15)) {
            return "FizzBuzz";
        } else if (isDivisibleBy(number, 5)) {
            return "Buzz";
        } else if (isDivisibleBy(number, 3)) {
            return "Fizz";
        } else {
            return number.toString();
        }
    }

    private boolean isDivisibleBy(Integer number, int x) {
        return number % x == 0;
    }
}
