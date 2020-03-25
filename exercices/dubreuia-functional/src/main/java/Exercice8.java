import java.util.List;

/*
 * Retourner un String qui représente concaténation des éléments s'ils sont multiples de 2, avec " et " entre chaque élément, multipliés par 5.
 *
 * Sortie attendue :
 *
 * ------------ Imperative ------------
 * 10 et 20 et 30 et 40
 * ------------ Functional ------------
 * 10 et 20 et 30 et 40
 */
public class Exercice8 {

    public static String imperative(List<Integer> elements) {
        StringBuilder joined = new StringBuilder();
        for (Integer element : elements) {
            if (element % 2 == 0) {
                element = element * 5;
                joined.append(element).append(" et ");
            }
        }
        return joined.substring(0, joined.length() - 4);
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
