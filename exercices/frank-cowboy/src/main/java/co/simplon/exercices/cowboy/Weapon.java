package co.simplon.exercices.cowboy;

import java.util.Objects;

public class Weapon {

    private final String name;

    private int bullets;

    private final int damages;

    /**
     * Construit une instance de {@code Weapon} avec les valeurs spécifiées.
     *
     * @param name    le nom de l'arme
     * @param bullets le nombre de balles
     * @param damages les dégâts causés par 1 balle
     * @throws NullPointerException     si {@code name} est {@code null}
     * @throws IllegalArgumentException si {@code bullets} est {@code < 1} ou {@code > 20}
     * @throws IllegalArgumentException si {@code damages} est {@code < 1} ou {@code > 3}
     */
    public Weapon(String name, int bullets, int damages) {
        Objects.requireNonNull(name, "name cannot be null");
        if (bullets < 1 || bullets > 20) {
            throw new IllegalArgumentException(
                    "bullets out of range [1-20]: " + bullets);
        }
        if (damages < 1 || damages > 3) {
            throw new IllegalArgumentException(
                    "damages out of range [1-3]: " + damages);
        }
        this.name = name;
        this.bullets = bullets;
        this.damages = damages;
    }

    /**
     * Tire une et une 1 balle, seulement s'il en reste.
     * <p>
     * Retourne les dégâts causés par la balle si cette dernière a pu être
     * tir�e.
     *
     * @return les dégâts causés par la balle; ou {@code 0} si plus de balle
     */
    public int fire() {
        // To be implemented
        return 0;
    }

    @Override
    public String toString() {
        return "{name=" + name + ", bullets=" + bullets + ", damages=" + damages + "}";
    }

}
