import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

public class YachtTest {

    @Test
    public void yacht() {
        Yacht yacht = new Yacht(List.of(4, 4, 4, 4, 4), YachtCategory.YACHT);

        int score = yacht.score();

        Assertions.assertEquals(50, score);
    }

    @Disabled("Remove to run test")
    @Test
    public void notYacht() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void ones() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void onesOutOfOrder() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void noOnes() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void twos() {
        Assertions.fail("TODO");
    }

    @Test
    public void fours() {
        Yacht yacht = new Yacht(List.of(4, 4, 1, 6, 2), YachtCategory.FOURS);

        int score = yacht.score();

        Assertions.assertEquals(8, score);
    }

    @Disabled("Remove to run test")
    @Test
    public void yachtCountedAsThrees() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void yachtOfThreesCountedAsFives() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void sixes() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void fullHouseTwoSmallThreeBig() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void fullHouseThreeSmallTwoBig() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void twoPairIsNotAFullHouse() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void fourOfAKindIsNotAFullHouse() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void yachtIsNotAFullHouse() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void fourOfAKind() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void yachtCanBeScoredAsFourOfAKind() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void fullHouseIsNotFourOfAKind() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void littleStraight() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void littleStraightAsBigStraight() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void fourInOrderButNotALittleStraight() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void noPairsButNotALittleStraight() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void minimumIs1MaximumIs5ButNotALittleStraight() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void bigStraight() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void bigStraightAsLittleStraight() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void noPairsButNotABigStraight() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void choice() {
        Assertions.fail("TODO");
    }

    @Disabled("Remove to run test")
    @Test
    public void yachtAsChoice() {
        Assertions.fail("TODO");
    }

}
