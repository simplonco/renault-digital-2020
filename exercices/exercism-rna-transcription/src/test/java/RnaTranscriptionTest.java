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
    public void testEmptyRnaSequence(){
        // given
        String dnaStrand = "";
        // when
        String actualRnaTranscription = rnaTranscription.transcribe(dnaStrand);
        // then
        Assert.assertEquals("", actualRnaTranscription);
    }


    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        // given
        String dnaStrand = "C";
        // when
        String actualRnaTranscription = rnaTranscription.transcribe(dnaStrand);
        // then
        Assert.assertEquals("G", actualRnaTranscription);
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

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscription() {
        Assert.fail();
    }

}
