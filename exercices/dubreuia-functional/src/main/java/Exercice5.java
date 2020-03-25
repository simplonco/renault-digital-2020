import java.util.List;
import java.util.Optional;

/*
 * Retourner un optional qui représente le premier élément multiple de 5 de la liste, multiplié par 10 (optional empty si la liste est vide).
 *
 * Sortie attendue :
 *
 * ------------ Imperative ------------
 * 50
 * null
 * ------------ Functional ------------
 * Optional[50]
 * Optional.empty
 */
public class Exercice5 {

    public static Integer imperative(List<Integer> elements) {
        for (var element : elements) {
            if (element % 5 == 0) {
                return element * 10;
            }
        }
        return null;
    }

    public static Optional<Integer> functional(List<Integer> elements) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        System.out.println("------------ Imperative ------------");
        System.out.println(imperative(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println(imperative(List.of()));
        System.out.println("------------ Functional ------------");
        System.out.println(functional(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println(functional(List.of()));
    }

}
