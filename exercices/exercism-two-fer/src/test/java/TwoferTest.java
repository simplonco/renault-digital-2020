import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TwoferTest {

    private Twofer twofer;

    @BeforeEach
    public void setup() {
        twofer = new Twofer();
    }

    @Test
    public void noNameGiven() {
     String reponse = twofer.twofer("");
     Assertions.assertEquals(reponse, "One for you, one for me.");
    }

    @Test
    public void aNameGiven(){
    String reponse = twofer.twofer("Alice");
    Assertions.assertEquals(reponse, "One for Alice, one for me.");
    }

    @Disabled("Remove to run test")
    @Test
    public void anotherNameGiven() {
        Assertions.fail("TODO");
    }

}
