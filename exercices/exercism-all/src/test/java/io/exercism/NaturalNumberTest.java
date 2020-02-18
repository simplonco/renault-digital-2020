package io.exercism;

import io.exercism.NaturalNumber.Classification;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NaturalNumberTest {


    @Disabled("Remove to run test")
    @Test
    public void testSmallPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(6).getClassification());
    }

    @Disabled("Remove to run test")
    @Test
    public void testMediumPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(28).getClassification());
    }

    @Disabled("Remove to run test")
    @Test
    public void testLargePerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(33550336).getClassification());
    }

    @Disabled("Remove to run test")
    @Test
    public void testSmallAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(12).getClassification());
    }

    @Disabled("Remove to run test")
    @Test
    public void testMediumAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(30).getClassification());
    }

    @Disabled("Remove to run test")
    @Test
    public void testLargeAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(33550335).getClassification());
    }

    @Disabled("Remove to run test")
    @Test
    public void testSmallestPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(2).getClassification());
    }

    @Disabled("Remove to run test")
    @Test
    public void testSmallestNonPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(4).getClassification());
    }

    @Disabled("Remove to run test")
    @Test
    public void testMediumDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(32).getClassification());
    }

    @Disabled("Remove to run test")
    @Test
    public void testLargeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(33550337).getClassification());
    }

    @Disabled("Remove to run test")
    @Test
    /*
     * The number 1 has no proper divisors (https://en.wikipedia.org/wiki/Divisor#Further_notions_and_facts), and the
     * additive identity is 0, so the aliquot sum of 1 should be 0. Hence 1 should be classified as deficient.
     */
    public void testThatOneIsCorrectlyClassifiedAsDeficient() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(1).getClassification());
    }

    @Disabled("Remove to run test")
    @Test
    public void testThatNonNegativeIntegerIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new NaturalNumber(0),
                "You must supply a natural number (positive integer)");
    }

    @Disabled("Remove to run test")
    @Test
    public void testThatNegativeIntegerIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new NaturalNumber(-1),
                "You must supply a natural number (positive integer)");
    }

}
