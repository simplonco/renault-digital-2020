package io.exercism;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class HammingTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Disabled("Remove to run test")
    @Test
    public void testNoDistanceBetweenEmptyStrands() {
        Assertions.assertEquals(0, new Hamming("", "").getHammingDistance());
    }

    @Disabled("Remove to run test")
    @Test
    public void testNoDistanceBetweenShortIdenticalStrands() {
        Assertions.assertEquals(0, new Hamming("A", "A").getHammingDistance());
    }

    @Disabled("Remove to run test")
    @Test
    public void testCompleteDistanceInSingleLetterDifferentStrands() {
        Assertions.assertEquals(1, new Hamming("G", "T").getHammingDistance());
    }

    @Disabled("Remove to run test")
    @Test
    public void testDistanceInLongIdenticalStrands() {
        Assertions.assertEquals(0, new Hamming("GGACTGAAATCTG", "GGACTGAAATCTG").getHammingDistance());
    }

    @Disabled("Remove to run test")
    @Test
    public void testDistanceInLongDifferentStrands() {
        Assertions.assertEquals(9, new Hamming("GGACGGATTCTG", "AGGACGGATTCT").getHammingDistance());
    }

    @Disabled("Remove to run test")
    @Test
    public void testValidatesFirstStrandNotLonger() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("leftStrand and rightStrand must be of equal length.");

        new Hamming("AATG", "AAA");
    }

    @Disabled("Remove to run test")
    @Test
    public void testValidatesSecondStrandNotLonger() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("leftStrand and rightStrand must be of equal length.");

        new Hamming("ATA", "AGTG");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDisallowLeftEmptyStrand() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("left strand must not be empty.");

        new Hamming("", "G");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDisallowRightEmptyStrand() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("right strand must not be empty.");

        new Hamming("G", "");
    }

}
