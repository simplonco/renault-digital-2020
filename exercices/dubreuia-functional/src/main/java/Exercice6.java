import java.util.List;
import java.util.Optional;

/*
 * Retourner un optional qui représente la réduction (somme) du contenu de la liste (optional empty si la liste est vide).
 *
 * - Java (Stream#reduce) : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html#reduce(java.util.function.BinaryOperator)
 * - JavaScript (Array#reduce) : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduce
 *
 * Sortie attendue :
 *
 * ------------ Imperative ------------
 * 45
 * null
 * ------------ Functional ------------
 * Optional[45]
 * Optional.empty
 */
public class Exercice6 {

    public static Integer imperative(List<Integer> elements) {
        if (elements.isEmpty()) {
            return null;
        }
        int sum = 0;
        for (var element : elements) {
            sum += element;
        }
        return sum;
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
