package co.simplon.exercices.cowboy;

import java.util.Objects;

public class Cowboy {

  private final String name;

  private int energy;

  private final Weapon weapon;

  /**
   * Construit une instance de {@code Cowboy} avec les valeurs spécifiées.
   *
   * @param name   le nom du cowboy
   * @param energy la quantité d'énergie du cowboy (sa vie en d'autres termes)
   * @param weapon une arme
   * @throws NullPointerException     si {@code name} ou {@code weapon} est {@code null}
   * @throws IllegalArgumentException si {@code energy} est {@code < 1} ou {@code > 100}
   */
  public Cowboy(String name, int energy, Weapon weapon) {
    Objects.requireNonNull(name, "name cannot be null");
    if (energy < 1 || energy > 100) {
      throw new IllegalArgumentException(
          "energy out of range [1-100]: " + energy);
    }
    Objects.requireNonNull(weapon, "weapon cannot be null");
    this.name = name;
    this.energy = energy;
    this.weapon = weapon;
  }

  /**
   * Fait utiliser son arme par ce cowboy sur un autre cowboy spécifié en
   * paramètre ({@code target}), si et seulement si la cible n'est pas déjà
   * morte.
   * <p>
   * Si la cible n'est pas morte et qu'un coup part alors l'énergie de la
   * cible est réduite du nombre de dégâts causé par l'arme. L'énergie d'un
   * cowboy ne peut pas être négative. Autrement dit, s'il reste 2 points
   * d'énergie à un cowboy et qu'il encaisse un tire dont la balle cause 3
   * points de dégât, son énergie atteint 0 et non -1.
   *
   * @param target un cowboy cible sur lequel tirer
   * @see Weapon#fire()
   */
  public void shoot(Cowboy target) {
    // To be implemented
  }

  /**
   * Indique si ce {@code cowboy} est mort ou non.
   *
   * @return {@code true} s'il est mort; {@code false} sinon
   */
  public boolean isDead() {
    // To be implemented
    return true;
  }

  @Override
  public String toString() {
    return "{name=" + name + ", energy=" + energy + ", weapon=" + weapon
        + ", dead=" + isDead() + "}";
  }

}
