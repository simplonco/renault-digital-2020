package io.exercism;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ResistorColorTest {

    private ResistorColor resistorColor;

    @BeforeEach
    public void setup() {
        resistorColor = new ResistorColor();
    }

    @Disabled("Remove to run test")
    @Test
    public void testBlackColorCode() {
        String input = "black";
        int expected = 0;

        Assertions.assertEquals(expected, resistorColor.colorCode(input));
    }

    @Disabled("Remove to run test")
    @Test
    public void testWhiteColorCode() {
        String input = "white";
        int expected = 9;

        Assertions.assertEquals(expected, resistorColor.colorCode(input));
    }

    @Disabled("Remove to run test")
    @Test
    public void testOrangeColorCode() {
        String input = "orange";
        int expected = 3;

        Assertions.assertEquals(expected, resistorColor.colorCode(input));
    }

    @Disabled("Remove to run test")
    @Test
    public void testColors() {
        String[] expected = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

        Assertions.assertEquals(expected, resistorColor.colors());
    }
    
}
