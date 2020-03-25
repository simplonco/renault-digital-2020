import java.util.ArrayList;
import java.util.List;

/*
 * Retourner une liste contenant seulement les éléments pairs de la liste donnée, multipliés par 5. Utiliser `filter` et `map`.
 *
 * Sortie attendue :
 *
 * ------------ Imperative ------------
 * [10, 20, 30, 40]
 * ------------ Functional ------------
 * [10, 20, 30, 40]
 */
public class Exercice3 {

    public static List<Integer> imperative(List<Integer> elements) {
        List<Integer> filteredAndMapped = new ArrayList<>();
        for (var element : elements) {
            if (element % 2 == 0) {
                filteredAndMapped.add(element * 5);
            }
        }
        return filteredAndMapped;
    }

    public static List<Integer> functional(List<Integer> elements) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        System.out.println("------------ Imperative ------------");
        System.out.println(imperative(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println("------------ Functional ------------");
        System.out.println(functional(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

}
