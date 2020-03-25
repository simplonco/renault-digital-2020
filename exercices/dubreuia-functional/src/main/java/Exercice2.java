import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Retourner une liste contenant seulement les éléments pairs de la liste donnée.
 *
 * - Java (Stream#filter) : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html#filter(java.util.function.Predicate)
 * - JavaScript (Array#filter) : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/filter
 *
 * Sortie attendue :
 *
 * ------------ Imperative ------------
 * [2, 4, 6, 8]
 * ------------ Functional ------------
 * [2, 4, 6, 8]
 */
public class Exercice2 {

    public static List<Integer> imperative(List<Integer> elements) {
        List<Integer> filtered = new ArrayList<>();
        for (var element : elements) {
            if (element % 2 == 0) {
                filtered.add(element);
            }
        }
        return filtered;
    }

    public static List<Integer> functional(List<Integer> elements) {
        return elements.stream()
                .filter(element -> element % 2 == 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("------------ Imperative ------------");
        System.out.println(imperative(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println("------------ Functional ------------");
        System.out.println(functional(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

}
