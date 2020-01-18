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
    public void testEmptyRnaSequence(){
        // given
        String dnaStrand = "";
        // when
        String actualRnaTranscription = rnaTranscription.transcribe(dnaStrand);
        // then
        Assertions.assertEquals("", actualRnaTranscription);
    }


    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        // given
        String dnaStrand = "C";
        // when
        String actualRnaTranscription = rnaTranscription.transcribe(dnaStrand);
        // then
        Assertions.assertEquals("G", actualRnaTranscription);
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
