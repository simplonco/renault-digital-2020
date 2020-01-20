import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

public class YachtTest {

    @Test
    public void yacht() {
        //given
        List<Integer> dices = List.of(1, 1, 1, 1, 1);
        YachtCategory category = YachtCategory.YACHT;
        Yacht yacht = new Yacht(dices, category);
        //when
        int result = yacht.score();
        //then
        Assertions.assertEquals(50, result);
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

    @Disabled("Remove to run test")
    @Test
    public void fours() {
        Assertions.fail("TODO");
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
