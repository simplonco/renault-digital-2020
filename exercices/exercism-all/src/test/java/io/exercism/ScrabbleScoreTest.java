package io.exercism;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ScrabbleScoreTest {

    @Disabled("Remove to run test")
    @Test
    public void testALowerCaseLetter() {
        Scrabble scrabble = new Scrabble("a");
        Assertions.assertEquals(1, scrabble.getScore());
    }

    @Disabled("Remove to run test")
    @Test
    public void testAUpperCaseLetter() {
        Scrabble scrabble = new Scrabble("A");
        Assertions.assertEquals(1, scrabble.getScore());
    }

    @Disabled("Remove to run test")
    @Test
    public void testAValuableLetter() {
        Scrabble scrabble = new Scrabble("f");
        Assertions.assertEquals(4, scrabble.getScore());
    }

    @Disabled("Remove to run test")
    @Test
    public void testAShortWord() {
        Scrabble scrabble = new Scrabble("at");
        Assertions.assertEquals(2, scrabble.getScore());
    }

    @Disabled("Remove to run test")
    @Test
    public void testAShortValuableWord() {
        Scrabble scrabble = new Scrabble("zoo");
        Assertions.assertEquals(12, scrabble.getScore());
    }

    @Disabled("Remove to run test")
    @Test
    public void testAMediumWord() {
        Scrabble scrabble = new Scrabble("street");
        Assertions.assertEquals(6, scrabble.getScore());
    }

    @Disabled("Remove to run test")
    @Test
    public void testAMediumValuableWord() {
        Scrabble scrabble = new Scrabble("quirky");
        Assertions.assertEquals(22, scrabble.getScore());
    }

    @Disabled("Remove to run test")
    @Test
    public void testALongMixCaseWord() {
        Scrabble scrabble = new Scrabble("OxyphenButazone");
        Assertions.assertEquals(41, scrabble.getScore());
    }

    @Disabled("Remove to run test")
    @Test
    public void testAEnglishLikeWord() {
        Scrabble scrabble = new Scrabble("pinata");
        Assertions.assertEquals(8, scrabble.getScore());
    }

    @Disabled("Remove to run test")
    @Test
    public void testAnEmptyInput() {
        Scrabble scrabble = new Scrabble("");
        Assertions.assertEquals(0, scrabble.getScore());
    }

    @Disabled("Remove to run test")
    @Test
    public void testEntireAlphabetAvailable() {
        Scrabble scrabble = new Scrabble("abcdefghijklmnopqrstuvwxyz");
        Assertions.assertEquals(87, scrabble.getScore());
    }

}
