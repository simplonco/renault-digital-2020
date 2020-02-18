package io.exercism;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProteinTranslatorTest {

    private ProteinTranslator proteinTranslator;

    @BeforeEach
    public void setUp() {
        proteinTranslator = new ProteinTranslator();
    }

    @Disabled("Remove to run test")
    @Test
    public void testMethionineRnaSequence() {
        List<String> expected = List.of("Methionine");
        Assertions.assertEquals(expected, proteinTranslator.translate("AUG"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testPhenylalanineRnaSequence1() {
        List<String> expected = List.of("Phenylalanine");
        Assertions.assertEquals(expected, proteinTranslator.translate("UUU"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testPhenylalanineRnaSequence2() {
        List<String> expected = List.of("Phenylalanine");
        Assertions.assertEquals(expected, proteinTranslator.translate("UUC"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testLeucineRnaSequence1() {
        List<String> expected = List.of("Leucine");
        Assertions.assertEquals(expected, proteinTranslator.translate("UUA"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testLeucineRnaSequence2() {
        List<String> expected = List.of("Leucine");
        Assertions.assertEquals(expected, proteinTranslator.translate("UUG"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testSerineRnaSequence1() {
        List<String> expected = List.of("Serine");
        Assertions.assertEquals(expected, proteinTranslator.translate("UCU"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testSerineRnaSequence2() {
        List<String> expected = List.of("Serine");
        Assertions.assertEquals(expected, proteinTranslator.translate("UCC"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testSerineRnaSequence3() {
        List<String> expected = List.of("Serine");
        Assertions.assertEquals(expected, proteinTranslator.translate("UCA"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testSerineRnaSequence4() {
        List<String> expected = List.of("Serine");
        Assertions.assertEquals(expected, proteinTranslator.translate("UCG"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testTyrosineRnaSequence1() {
        List<String> expected = List.of("Tyrosine");
        Assertions.assertEquals(expected, proteinTranslator.translate("UAU"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testTyrosineRnaSequence2() {
        List<String> expected = List.of("Tyrosine");
        Assertions.assertEquals(expected, proteinTranslator.translate("UAC"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testCysteineRnaSequence1() {
        List<String> expected = List.of("Cysteine");
        Assertions.assertEquals(expected, proteinTranslator.translate("UGU"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testCysteineRnaSequence2() {
        List<String> expected = List.of("Cysteine");
        Assertions.assertEquals(expected, proteinTranslator.translate("UGC"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testTryptophanRnaSequence1() {
        List<String> expected = List.of("Tryptophan");
        Assertions.assertEquals(expected, proteinTranslator.translate("UGG"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testStopRnaSequence1() {
        List<String> expected = List.of();
        Assertions.assertEquals(expected, proteinTranslator.translate("UAA"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testStopRnaSequence2() {
        List<String> expected = List.of();
        Assertions.assertEquals(expected, proteinTranslator.translate("UAG"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testStopRnaSequence3() {
        List<String> expected = List.of();
        Assertions.assertEquals(expected, proteinTranslator.translate("UGA"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testTranslationOfRnaToProteinList() {
        List<String> expected = List.of("Methionine", "Phenylalanine", "Tryptophan");
        Assertions.assertEquals(expected, proteinTranslator.translate("AUGUUUUGG"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonAtBeginning() {
        List<String> expected = List.of();
        Assertions.assertEquals(expected, proteinTranslator.translate("UAGUGG"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonAtEnd1() {
        List<String> expected = List.of("Tryptophan");
        Assertions.assertEquals(expected, proteinTranslator.translate("UGGUAG"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonAtEnd2() {
        List<String> expected = List.of("Methionine", "Phenylalanine");
        Assertions.assertEquals(expected, proteinTranslator.translate("AUGUUUUAA"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonInMiddle1() {
        List<String> expected = List.of("Tryptophan");
        Assertions.assertEquals(expected, proteinTranslator.translate("UGGUAGUGG"));
    }

    @Disabled("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonInMiddle2() {
        List<String> expected = List.of("Tryptophan", "Cysteine", "Tyrosine");
        Assertions.assertEquals(expected, proteinTranslator.translate("UGGUGUUAUUAAUGGUUU"));
    }

}
