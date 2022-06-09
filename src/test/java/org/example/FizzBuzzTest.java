package org.example;

import org.example.FizzBuzz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void shouldReturnFizz() {
        assertThat(fizzBuzz.fizzBuzz(3)).isEqualTo("Fizz");
    }

    @Test
    void shouldReturnFizzBuzz() {
        assertThat(fizzBuzz.fizzBuzz(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void shouldReturnBuzz() {
        assertThat(fizzBuzz.fizzBuzz(5)).isEqualTo("Buzz");
    }

    @Test
    void shouldReturnNumber() {
        assertThat(fizzBuzz.fizzBuzz(14)).isEqualTo("14");
    }
}
