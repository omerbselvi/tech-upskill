package org.example;

import org.example.PrimeFactor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrimeFactorTest {

    private PrimeFactor primeFactor;

    @BeforeEach
    void setUp() {
        primeFactor = new PrimeFactor();
    }

    @Test
    void shouldReturnPrimeFactors() {
        assertThat(primeFactor.primeFactors(120)).isEqualTo(List.of(2, 2, 2, 3, 5));
        assertThat(primeFactor.primeFactors(10)).isEqualTo(List.of(2, 5));
        assertThat(primeFactor.primeFactors(30)).isEqualTo(List.of(2, 3, 5));
    }
}
