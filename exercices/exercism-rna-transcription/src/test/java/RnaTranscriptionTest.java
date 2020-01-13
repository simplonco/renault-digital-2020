import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RnaTranscriptionTest {

    private RnaTranscription rnaTranscription;

    @Before
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
        Assert.assertEquals("", transcribe);
    }

    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        // data
        String dnaStrand = "C";

        // exec
        String transcribe = rnaTranscription.transcribe(dnaStrand);

        // verif
        Assert.assertEquals("G", transcribe);
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfGuanineIsCytosine() {
        Assert.fail();
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfThymineIsAdenine() {
        Assert.fail();
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfAdenineIsUracil() {
        Assert.fail();
    }

    @Test
    public void testRnaTranscription() {
        // data
        String dnaStrand = "GCTAA";

        // exec
        String transcription = rnaTranscription.transcribe(dnaStrand);

        // assert
        Assert.assertEquals("CGAUU", transcription);
    }

}
