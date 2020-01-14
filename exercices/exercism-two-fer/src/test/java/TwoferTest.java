import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TwoferTest {

    private Twofer twofer;

    @Before
    public void setup() {
        twofer = new Twofer();
    }

    @Test
    public void noNameGiven() {
     String reponse = twofer.twofer("");
     Assert.assertEquals(reponse, "One for you, one for me.");
    }

    @Test
    public void aNameGiven(){
    String reponse = twofer.twofer("Alice");
    Assert.assertEquals(reponse, "One for Alice, one for me.");
    }

    @Ignore("Remove to run test")
    @Test
    public void anotherNameGiven() {
        Assert.fail("TODO");
    }

}
