import java.util.List;

/*
 * Imprimer chacun des éléments de la liste sur sa propre ligne.
 *
 * - Java (List#forEach) : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html#forEach(java.util.function.Consumer)
 * - JavaScript (Array#forEach) : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach
 *
 * Sortie attendue :
 *
 * ------------ Imperative ------------
 * 1
 * 2
 * 3
 * ------------ Functional ------------
 * 1
 * 2
 * 3
 */
public class Exercice0 {

    public static void imperative(List<Integer> elements) {
        for (var element : elements) {
            System.out.println(element);
        }
    }

    public static void functional(List<Integer> elements) {
        // TODO
    }

    public static void main(String[] args) {
        System.out.println("------------ Imperative ------------");
        imperative(List.of(1, 2, 3));
        System.out.println("------------ Functional ------------");
        functional(List.of(1, 2, 3));
    }

}
