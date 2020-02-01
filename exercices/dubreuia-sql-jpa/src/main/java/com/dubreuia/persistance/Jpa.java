package com.dubreuia.persistance;

import com.dubreuia.bean.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Jpa {

    public static void main(String[] args) {
        Student student;

        student = getStudentsWithId(10);
        if (student == null) {
            insertStudent(new Student(10, "Barack", "Obama", "1961-08-04", 5.7));
        } else {
            System.out.println(student);
        }

        student = getStudentsWithId(20);
        if (student == null) {
            insertStudentNoCommit(new Student(20, "Barack", "Obama", "1961-08-04", 5.7));
        } else {
            System.out.println(student);
        }

        student = getStudentsWithId(30);
        if (student == null) {
            insertStudentNoCommit(new Student(30, "Barack", "Obama", "1961-08-04", 5.7));
        } else {
            System.out.println(student);
        }
    }

    private static Student getStudentsWithId(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("database");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, id);
        try {
            return student;
        } finally {
            entityManagerFactory.close();
        }
    }

    private static void insertStudent(Student student) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("database");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(student);
        transaction.commit();
        entityManagerFactory.close();
    }

    private static void insertStudentNoCommit(Student student) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("database");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(student);
        entityManagerFactory.close();
    }

    private static void insertStudentCommitAndRollback(Student student) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("database");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(student);
        transaction.commit();
        transaction.rollback();
        entityManagerFactory.close();
    }

}
