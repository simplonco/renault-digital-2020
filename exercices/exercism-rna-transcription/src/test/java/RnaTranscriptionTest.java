import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class RnaTranscriptionTest {

    private RnaTranscription rnaTranscription;

    @BeforeEach
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
        Assertions.assertEquals("",results);
    }

    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        //Given -> data
        String dnaStrand = "C";
        //When -> executing
        String results = rnaTranscription.transcribe(dnaStrand);
        //Then -> verification
        Assertions.assertEquals("G",results);
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

    @Disabled("Remove to run test")
    @Test
    public void testRnaTranscription() {
        Assertions.fail();
    }

}
