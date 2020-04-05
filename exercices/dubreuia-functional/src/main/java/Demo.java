import java.util.Collections;
import java.util.List;

/*
 * Retourne la liste des éléments commençant par "t", transformés en lowercase.
 *
 * Entrée: [Merope, Terpsichore, Hebe, Pheme, Themis, Eileithyia, Atropos]
 * Sortie: [terpsichore, themis]
 */
public class Demo {

    public static List<String> imperative(List<String> elements) {
        return Collections.emptyList();
    }

    public static List<String> functional(List<String> elements) {
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        List<String> names = List.of("Merope", "Terpsichore", "Hebe", "Pheme", "Themis", "Eileithyia", "Atropos");
        System.out.println("------------ Imperative ------------");
        System.out.println(imperative(names));
        System.out.println("------------ Functional ------------");
        System.out.println(functional(names));
    }

}