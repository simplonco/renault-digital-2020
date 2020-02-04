package com.dubreuia.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Créer une classe étudiant avec les attributs suivants :
 * <p>
 * - id (int)
 * - firstName (String)
 * - lastName (String)
 * - birthdate (String)
 * - note (double)
 * <p>
 * Utiliser les annotations suivantes pour paramétrer l'entité :
 * <p>
 * - {@link Entity} pour déclarer le lien entre la classe et la table
 * - {@link Id} pour déclarer la clef primaire
 * - {@link Column} pour déclarer une colonne
 *
 * // java bean
 */
@Entity(name = "students")
public class Student {

    @Id
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "note")
    private double note;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String birthdate, double note) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
