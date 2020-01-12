package co.simplon.exercices.vat;

public class Application {

  /**
   * Ecrire le programme qui calcule pour chaque prix TTC le prix HT et
   * affiche le tout dans la console exactement comme dans les exemples
   * donnés. Un exemple quand la mathode calculateWithoutTax est appelé avec
   * rounded = false et un autre quand la mathode calculateWithoutTax est
   * appelé avec rounded = true. Ainsi pour chaque price et rate il faut
   * appeler la méthode calculateWithoutTax avec les paramètres correspondants
   * ce qui permettra d'afficher tout ce qui est attendu dans la console.
   */
  public static void main(String[] args) {
    /*
     * Prices contient des prix TTC (With VAT) et rates les taux de TVA
     * correspondant, ainsi le taux du premier price (49.99) est 20.0.
     */
    double[] prices = {49.99, 19.99, 9.99, 14.59, 99.99};
    double[] rates = {20.0, 10.0, 10.0, 5.0, 20.0};
  }

  private static double calculateWithoutTax(double price, double rate,
                                            boolean rounded) {
    // Implémenter pour que result = price HT basé sur rate
    double result = 0.0;
    /*
     * Retourne le résultat arrondi ou non en fonction de rounded = false ou
     * rounded = true. Rien à changer ci-dessous.
     */
    return rounded ? round(result) : result;
  }

  private static double round(double result) {
    /*
     * Implémenter pour retourner result arrondi à 2 décimales. Il existe
     * plusieurs méthodes pour arrondir en Java, travail de recherche sur
     * Google...
     */
    return result;
  }

}
