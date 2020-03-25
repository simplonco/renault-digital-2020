import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Retourner une liste contenant la multiplication par 2 de chaque élément (int) de la liste donnée.
 *
 * - Java (Stream#map) : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html#map(java.util.function.Function)
 * - JavaScript (Array#map) : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/map
 *
 * Sortie attendue :
 *
 * ------------ Imperative ------------
 * [2, 4, 6, 8, 10, 12, 14, 16, 18]
 * ------------ Functional ------------
 * [2, 4, 6, 8, 10, 12, 14, 16, 18]
 */
public class Exercice1 {

    public static List<Integer> imperative(List<Integer> elements) {
        List<Integer> mapped = new ArrayList<>();
        for (var element : elements) {
            mapped.add(element * 2);
        }
        return mapped;
    }

    public static List<Integer> functional(List<Integer> elements) {
        return elements.stream()
                .map(element -> element * 2)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("------------ Imperative ------------");
        System.out.println(imperative(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println("------------ Functional ------------");
        System.out.println(functional(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

}
