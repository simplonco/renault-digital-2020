package com.dubreuia.persistance;

import com.dubreuia.bean.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class Jpa {

    public static void main(String[] args) {
        Student obama = new Student(0, "Barack", "Obama", LocalDate.of(1961, 03, 15), null);
        if (!isStudentPresent(obama)) {
            addStudent(obama);
        }
        printStudents();
    }

    /**
     * Imprime dans la console les étudiants de la table "students", ligne par ligne, selon le format suivant :
     * "Student{id=1, firstName='Barack', lastName='Obama', birthdate=1961-03-15, note=null}"
     * <p>
     * - {@link Persistence#createEntityManagerFactory(String)}
     * - {@link EntityManagerFactory#createEntityManager()}
     * - {@link EntityManager#createQuery(String, Class)}
     * - {@link TypedQuery#getResultList()}
     */
    private static void printStudents() {
        EntityManagerFactory database = Persistence.createEntityManagerFactory("database");
        EntityManager entityManager = database.createEntityManager();
        String qlstring = "SELECT s FROM students s";
        TypedQuery<Student> query = entityManager.createQuery(qlstring, Student.class);
        List<Student> resultList = query.getResultList();
        for (Student student : resultList) {
            System.out.println(student);
        }
    }

    /**
     * Ajoute un étudiant dans la table "students".
     * <p>
     * - {@link Persistence#createEntityManagerFactory(String)}
     * - {@link EntityManager#getTransaction#begin()}
     * - {@link EntityManager#persist(Object)}
     * - {@link EntityManager#getTransaction()#commit()}
     */
    private static void addStudent(Student student) {
        EntityManagerFactory database = Persistence.createEntityManagerFactory("database");
        EntityManager entityManager = database.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        Student george = entityManager.find(Student.class, 2);
        System.out.println(george);
    }

    /**
     * Retourne vrai si l'étudiant est présent dans la table "students".
     * <p>
     * - {@link Persistence#createEntityManagerFactory(String)}
     * - {@link EntityManagerFactory#createEntityManager()}
     * - {@link EntityManager#createQuery(String, Class)}
     * - {@link TypedQuery#setParameter(String, Object)}
     * - {@link TypedQuery#getResultList()}
     */
    private static boolean isStudentPresent(Student student) {
        // TODO
        return false;
    }

}
