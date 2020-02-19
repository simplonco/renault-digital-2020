package io.exercism;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AcronymTest {

    @Test
    public void basic() {
        String phrase = "Portable Network Graphics";
        String expected = "PNG";
        Assertions.assertEquals(expected, new Acronym(phrase).get());
    }

    @Test
    public void lowercaseWords() {
        String phrase = "Ruby on Rails";
        String expected = "ROR";
        Assertions.assertEquals(expected, new Acronym(phrase).get());
    }

    @Test
    public void punctuation() {
        String phrase = "First In, First Out";
        String expected = "FIFO";
        Assertions.assertEquals(expected, new Acronym(phrase).get());
    }

    @Test
    public void nonAcronymAllCapsWord() {
        String phrase = "GNU Image Manipulation Program";
        String expected = "GIMP";
        Assertions.assertEquals(expected, new Acronym(phrase).get());
    }

    @Test
    public void punctuationWithoutWhitespace() {
        String phrase = "Complementary metal-oxide semiconductor";
        String expected = "CMOS";
        Assertions.assertEquals(expected, new Acronym(phrase).get());
    }

    @Test
    public void veryLongAbbreviation() {
        String phrase = "Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me";
        String expected = "ROTFLSHTMDCOALM";
        Assertions.assertEquals(expected, new Acronym(phrase).get());
    }

    @Test
    public void consecutiveDelimiters() {
        String phrase = "Something - I made up from thin air";
        String expected = "SIMUFTA";
        Assertions.assertEquals(expected, new Acronym(phrase).get());
    }

    @Test
    public void apostrophes() {
        String phrase = "Halley's Comet";
        String expected = "HC";
        Assertions.assertEquals(expected, new Acronym(phrase).get());
    }

    @Test
    public void underscoreEmphasis() {
        String phrase = "The Road _Not_ Taken";
        String expected = "TRNT";
        Assertions.assertEquals(expected, new Acronym(phrase).get());
    }


}
