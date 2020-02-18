package com.dubreuia.persistance;

import com.dubreuia.bean.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

// hibernate
public class Jpa {

    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("database");

    public static void main(String[] args) {
        try {
            Student obama = new Student("Barack", "Obama", LocalDate.of(1961, 3, 15));
            if (!isStudentPresent(obama)) {
                addStudent(obama);
            }
            printStudents();
        } finally {
            ENTITY_MANAGER_FACTORY.close();
        }
    }

    /**
     * Imprime dans la console les étudiants de la table "students", ligne par ligne, selon le format suivant :
     * "Student{id=1, firstName='Barack', lastName='Obama', birthdate=1961-03-15, note=null}"
     */
    private static void printStudents() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String qlString = "SELECT s FROM students s";
        TypedQuery<Student> query = entityManager.createQuery(qlString, Student.class);
        List<Student> resultList = query.getResultList();
        for (Student student : resultList) {
            System.out.println(student);
        }
    }

    /**
     * Ajoute un étudiant dans la table "students".
     */
    private static void addStudent(Student student) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    /**
     * Retourne vrai si l'étudiant est présent dans la table "students".
     */
    private static boolean isStudentPresent(Student student) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String qlString = "SELECT s FROM students s " +
                "WHERE s.firstName = :firstName " +
                "AND s.lastName = :lastName " +
                "AND s.birthdate = :birthdate ";
        TypedQuery<Student> query = entityManager.createQuery(qlString, Student.class);
        query.setParameter("firstName", student.getFirstName());
        query.setParameter("lastName", student.getLastName());
        query.setParameter("birthdate", student.getBirthdate());
        List<Student> resultList = query.getResultList();
        return resultList.contains(student);
    }

}
