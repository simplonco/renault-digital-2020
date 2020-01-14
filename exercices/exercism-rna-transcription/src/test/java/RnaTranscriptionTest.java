import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RnaTranscriptionTest {

    private RnaTranscription rnaTranscription;

    @Before
    public void init() {
        rnaTranscription = new RnaTranscription();
    }

    @Test
    public void testEmptyRnaSequence() {
        //Given -> data
        String dnaStrand = "";
        //When -> executing
       String results = rnaTranscription.transcribe(dnaStrand);
       //Then -> verification
        Assert.assertEquals("",results);
    }

    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        //Given -> data
        String dnaStrand = "C";
        //When -> executing
        String results = rnaTranscription.transcribe(dnaStrand);
        //Then -> verification
        Assert.assertEquals("G",results);
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
