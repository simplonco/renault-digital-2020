import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Yacht {

    private final List<Integer> dice;
    private final YachtCategory yachtCategory;

    Yacht(List<Integer> dices, YachtCategory yachtCategory) {
        this.dice = dices;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        if (yachtCategory.equals(YachtCategory.YACHT)) {
            if (dice.stream().allMatch(value -> value.equals(dice.get(0)))) {
                return 50;
            }
            return 0;
        } else if (yachtCategory.equals(YachtCategory.FOURS)) {
            return dice.stream()
                    .filter(element -> element == 4)
                    .reduce(Integer::sum)
                    .get();
        }
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Integer[] diceArray = new Integer[]{4, 4, 5, 1, 2};
        List<Integer> diceList = Arrays.asList(diceArray);
        Optional<Integer> reduce = diceList.stream().reduce(Integer::sum);
        reduce.ifPresent(System.out::println);
    }

}
