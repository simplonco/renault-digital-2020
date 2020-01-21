import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

public class YachtTest {

    @Disabled("Remove to run test")
    @Test
    public void yacht() {
        Assertions.fail("TODO");
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

    @Test
    public void twos() {
        // given
        List<Integer> list = List.of(4, 1, 3, 4, 2);
        YachtCategory yachtCategory = YachtCategory.TWOS;
        Yacht yacht = new Yacht(list, yachtCategory);
        // when
        int resultat = yacht.score();
        // then
        Assertions.assertEquals(resultat, 2);
    }

    @Test
    public void fours() {
        // given
        List<Integer> list = List.of(4, 1, 3, 4, 2);
        YachtCategory yachtCategory = YachtCategory.FOURS;
        Yacht yacht = new Yacht(list, yachtCategory);
        // when
        int resultat = yacht.score();
        // then
        Assertions.assertEquals(resultat, 8);
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
