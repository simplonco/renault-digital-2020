package io.exercism;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PangramCheckerTest {

    private PangramChecker pangramChecker;

    @BeforeEach
    public void setup() {
        pangramChecker = new PangramChecker();
    }

    @Disabled("Remove to run test")
    @Test
    public void emptySentenceIsNotPangram() {
        Assertions.assertFalse(pangramChecker.isPangram(""));
    }

    @Disabled("Remove to run test")
    @Test
    public void perfectLowerCasePhraseIsPangram() {
        Assertions.assertTrue(pangramChecker.isPangram("abcdefghijklmnopqrstuvwxyz"));
    }

    @Disabled("Remove to run test")
    @Test
    public void phraseWithOnlyLowerCaseIsPangram() {
        Assertions.assertTrue(pangramChecker.isPangram("the quick brown fox jumps over the lazy dog"));
    }

    @Disabled("Remove to run test")
    @Test
    public void phraseMissingCharacterXIsNotPangram() {
        Assertions.assertFalse(pangramChecker.isPangram("a quick movement of the enemy will jeopardize five gunboats"));
    }

    @Disabled("Remove to run test")
    @Test
    public void phraseMissingCharacterHIsNotPangram() {
        Assertions.assertFalse(pangramChecker.isPangram("five boxing wizards jump quickly at it"));
    }

    @Disabled("Remove to run test")
    @Test
    public void phraseWithUnderscoresIsPangram() {
        Assertions.assertTrue(pangramChecker.isPangram("the_quick_brown_fox_jumps_over_the_lazy_dog"));
    }

    @Disabled("Remove to run test")
    @Test
    public void phraseWithNumbersIsPangram() {
        Assertions.assertTrue(pangramChecker.isPangram("the 1 quick brown fox jumps over the 2 lazy dogs"));
    }

    @Disabled("Remove to run test")
    @Test
    public void phraseWithMissingLettersReplacedByNumbersIsNotPangram() {
        Assertions.assertFalse(pangramChecker.isPangram("7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog"));
    }

    @Disabled("Remove to run test")
    @Test
    public void phraseWithMixedCaseAndPunctuationIsPangram() {
        Assertions.assertTrue(pangramChecker.isPangram("\"Five quacking Zephyrs jolt my wax bed.\""));
    }

    @Disabled("Remove to run test")
    @Test
    public void caseInsensitivePhraseIsNotPangram() {
        Assertions.assertFalse(pangramChecker.isPangram("the quick brown fox jumps over with lazy FX"));
    }
}
