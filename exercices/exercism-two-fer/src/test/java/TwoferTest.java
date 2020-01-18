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

    @Disabled("Remove to run test")
    @Test
    public void noNameGiven() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void aNameGiven() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void anotherNameGiven() {
        Assertions.fail("TODO");
    }

}
