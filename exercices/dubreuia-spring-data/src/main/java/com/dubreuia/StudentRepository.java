package com.dubreuia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByLastName(String lastName);

    @Query("SELECT o FROM students o WHERE o.firstName = :fn AND o.lastName = :ln")
    Student findByName(@Param("fn") String firsName, @Param("ln") String lastName);

}
