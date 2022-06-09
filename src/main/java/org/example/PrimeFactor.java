package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {

    public List<Integer> primeFactors(Integer number) {
        List<Integer> primeFactors = new ArrayList<>();

        for (int i = 2; i < number; i++) {
            while (number % i == 0) {
                primeFactors.add(i);
                number = number / i;
            }
        }
        if (number > 2) {
            primeFactors.add(number);
        }
        return primeFactors;
    }
}
