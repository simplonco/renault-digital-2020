import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class RnaTranscriptionTest {

    private RnaTranscription rnaTranscription;

    @BeforeEach
    public void setUp() {
        rnaTranscription = new RnaTranscription();
    }

    @Test
    public void testEmptyRnaSequence() {
        // data
        String dnaStrand = "";

        // execute
        String transcribe = rnaTranscription.transcribe(dnaStrand);

        // verif
        Assertions.assertEquals("", transcribe);
    }

    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        // data
        String dnaStrand = "C";

        // exec
        String transcribe = rnaTranscription.transcribe(dnaStrand);

        // verif
        Assertions.assertEquals("G", transcribe);
    }

    @Disabled("Remove to run test")
    @Test
    public void testRnaTranscriptionOfGuanineIsCytosine() {
        Assertions.fail();
    }

    @Disabled("Remove to run test")
    @Test
    public void testRnaTranscriptionOfThymineIsAdenine() {
        Assertions.fail();
    }

    @Disabled("Remove to run test")
    @Test
    public void testRnaTranscriptionOfAdenineIsUracil() {
        Assertions.fail();
    }

    @Test
    public void testRnaTranscription() {
        // data
        String dnaStrand = "GCTAA";

        // exec
        String transcription = rnaTranscription.transcribe(dnaStrand);

        // assert
        Assertions.assertEquals("CGAUU", transcription);
    }

}
