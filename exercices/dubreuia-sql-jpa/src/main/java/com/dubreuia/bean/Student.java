package com.dubreuia.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

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
 * - {@link GeneratedValue}
 */
// Java Bean
@Entity(name = "students")
public class Student extends Object {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false, length = 128)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 128)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column
    private Double note;

    public Student() {
        // java bean jpa
    }

    public Student(int id, String firstName, String lastName, LocalDate birthdate, Double note) {
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", note=" + note +
                '}';
    }

}
