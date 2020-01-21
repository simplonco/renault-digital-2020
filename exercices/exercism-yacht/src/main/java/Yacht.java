import java.util.List;

class Yacht {

    // variable instance (field) (js: propriete)
    private List<Integer> dices;
    private YachtCategory yachtCategory;

    // variable locale
    Yacht(List<Integer> dices, YachtCategory yachtCategory) {
        this.dices = dices;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        int multiplicateur;
        if (yachtCategory.equals(YachtCategory.FOURS)) {
            multiplicateur = 4;
        } else if (yachtCategory.equals(YachtCategory.TWOS)) {
            multiplicateur = 2;
        } else {
            // default
            multiplicateur = 0;
        }
        int compteur = 0;
        for (int dice : dices) {
            if (dice == multiplicateur) {
                compteur++;
            }
        }
        return compteur * multiplicateur;
    }

}
