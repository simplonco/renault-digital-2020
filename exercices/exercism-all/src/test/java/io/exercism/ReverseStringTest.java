package io.exercism;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ReverseStringTest {

    @Disabled("Remove to run test")
    @Test
    public void testAnEmptyString() {
        Assertions.assertEquals("", new ReverseString().reverse(""));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAWord() {
        Assertions.assertEquals("tobor", new ReverseString().reverse("robot"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testACapitalizedWord() {
        Assertions.assertEquals("nemaR", new ReverseString().reverse("Ramen"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testASentenceWithPunctuation() {
        Assertions.assertEquals("!yrgnuh m'I", new ReverseString().reverse("I'm hungry!"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAPalindrome() {
        Assertions.assertEquals("racecar", new ReverseString().reverse("racecar"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAnEvenSizedWord() {
        Assertions.assertEquals("reward", new ReverseString().reverse("drawer"));
    }

}
