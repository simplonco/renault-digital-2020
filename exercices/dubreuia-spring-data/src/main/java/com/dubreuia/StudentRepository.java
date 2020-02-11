package com.dubreuia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM students s WHERE s.firstName = :fn AND s.lastName = :ln")
    Student findByName(@Param("fn") String firstName, @Param("ln") String lastName);

}
