import java.util.List;
import java.util.Map;
import java.util.Set;

class Yacht {

    private final List<Integer> dices;
    private final YachtCategory yachtCategory;

    Yacht(List<Integer> dices, YachtCategory yachtCategory) {
        this.dices = dices;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        if (yachtCategory.equals(YachtCategory.YACHT)) {
            Integer last = null;
            for (Integer dice : dices) {
                if (last == null) {
                    last = dice;
                    continue;
                }
                if (!last.equals(dice)) {
                    return 0;
                }
                last = dice;
            }
            return 50;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> dicesList = List.of(1, 2, 3, 4, 5, 6);
        Set<Integer> dicesSet = Set.of(1, 2, 3, 4, 5, 6);
        Map<String, Integer> dicesMap = Map.of("one", 1, "two", 2, "three", 3);
        dicesMap.get("one"); // 1
        dicesMap.get("three"); // 3
        dicesMap.get("toto"); // null
    }

}
