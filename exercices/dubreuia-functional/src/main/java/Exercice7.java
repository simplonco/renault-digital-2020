import java.util.List;

/*
 * Retourner un String qui représente concaténation du contenu de la liste avec " et " entre chaque élément.
 *
 * - Java (Collector#joining) : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Collectors.html#joining(java.lang.CharSequence)
 * - JavaScript (Array#join) : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/join
 *
 * Sortie attendue :
 *
 * ------------ Imperative ------------
 * 1 et 2 et 3 et 4 et 5 et 6 et 7 et 8 et 9
 * ------------ Functional ------------
 * 1 et 2 et 3 et 4 et 5 et 6 et 7 et 8 et 9
 */
public class Exercice7 {

    public static String imperative(List<Integer> elements) {
        String joined = "";
        for (Integer element : elements) {
            joined += element;
            if (elements.indexOf(element) != elements.size() - 1) {
                joined += " et ";
            }
        }
        return joined;
    }

    public static String functional(List<Integer> elements) {
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
