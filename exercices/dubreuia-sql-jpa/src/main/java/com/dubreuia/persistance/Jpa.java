package com.dubreuia.persistance;

import com.dubreuia.bean.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Jpa {

    public static void main(String[] args) {
        Student student;

        student = getStudentsWithId(10);
        if (student == null) {
            insertStudent(new Student());
        } else {
            System.out.println(student);
        }

        student = getStudentsWithId(20);
        if (student == null) {
            insertStudentNoCommit(new Student());
        } else {
            System.out.println(student);
        }

        student = getStudentsWithId(30);
        if (student == null) {
            insertStudentNoCommit(new Student());
        } else {
            System.out.println(student);
        }
    }

    private static Student getStudentsWithId(int id) {
        return null;
    }

    private static void insertStudent(Student student) {
    }

    private static void insertStudentNoCommit(Student student) {
    }

    private static void insertStudentCommitAndRollback(Student student) {
    }

}
