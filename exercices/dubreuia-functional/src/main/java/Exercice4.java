import java.util.List;
import java.util.Optional;

/*
 * Retourner un optional qui représente le premier élément de la liste (optional empty si la liste est vide).
 *
 * - Java (Optional) : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Optional.html
 * - JavaScript (optional chaining) : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
 *
 * Sortie attendue :
 *
 * ------------ Imperative ------------
 * 1
 * null
 * ------------ Functional ------------
 * Optional[1]
 * Optional.empty
 */
public class Exercice4 {

    public static Integer imperative(List<Integer> elements) {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.get(0);
    }

    public static Optional<Integer> functional(List<Integer> elements) {
        return elements.stream().findFirst();
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
