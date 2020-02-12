package io.exercism;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LeapTest {

    private Leap leap;

    @BeforeEach
    public void setup() {
        leap = new Leap();
    }

    @Disabled("Remove to run test")
    @Test
    public void testYearNotDivBy4InCommonYear() {
        Assertions.assertFalse(leap.isLeapYear(2015));
    }

    @Disabled("Remove to run test")
    @Test
    public void testYearDivBy2NotDivBy4InCommonYear() {
        Assertions.assertFalse(leap.isLeapYear(1970));
    }

    @Disabled("Remove to run test")
    @Test
    public void testYearDivBy4NotDivBy100InLeapYear() {
        Assertions.assertTrue(leap.isLeapYear(1996));
    }

    @Disabled("Remove to run test")
    @Test
    public void testYearDivBy4And5InLeapYear() {
        Assertions.assertTrue(leap.isLeapYear(1960));
    }

    @Disabled("Remove to run test")
    @Test
    public void testYearDivBy100NotDivBy400InCommonYear() {
        Assertions.assertFalse(leap.isLeapYear(2100));
    }

    @Disabled("Remove to run test")
    @Test
    public void testYearDivBy100NotDivBy3IsNotLeapYear() {
        Assertions.assertFalse(leap.isLeapYear(1900));
    }

    @Disabled("Remove to run test")
    @Test
    public void testYearDivBy400InLeapYear() {
        Assertions.assertTrue(leap.isLeapYear(2000));
    }

    @Disabled("Remove to run test")
    @Test
    public void testYearDivBy400NotDivBy125IsLeapYear() {
        Assertions.assertTrue(leap.isLeapYear(2400));
    }

    @Disabled("Remove to run test")
    @Test
    public void testYearDivBy200NotDivBy400InCommonYear() {
        Assertions.assertFalse(leap.isLeapYear(1800));
    }

}
