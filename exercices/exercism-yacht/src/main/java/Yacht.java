import java.util.List;

class Yacht {

    // variable instance
    private List<Integer> dices;

    //
    private YachtCategory yachtCategory;

    // parametre (variable locale)
    Yacht(List<Integer> dices, YachtCategory yachtCategory) {
        this.dices = dices;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        int multiplicateur;
        if (yachtCategory.equals(YachtCategory.THREES)) {
            multiplicateur = 3;
        } else if (yachtCategory.equals(YachtCategory.SIXES)) {
            multiplicateur = 6;
        } else {
            multiplicateur = 0;
        }
        int counter = 0;
        for (int value : dices) {
            if (value == multiplicateur) {
                counter++;
            }
        }
        return counter * multiplicateur;
    }

}
