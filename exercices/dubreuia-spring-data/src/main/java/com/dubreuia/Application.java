package com.dubreuia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication()
public class Application {

    @Autowired
    private StudentRepository repository;

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            System.out.println("delete all");
            repository.deleteAll();

            System.out.println("find all");
            System.out.println(repository.findAll());

            System.out.println("add barack and find all");
            repository.save(new Student("Barack", "Obama", LocalDate.of(1965, 7, 17)));
            List<Student> all = repository.findAll();
            System.out.println(all);

            Student firstStudent = all.get(0);
            System.out.println("find by id " + firstStudent.getId());
            System.out.println(repository.findById(firstStudent.getId()));

            System.out.println("find by last name");
            System.out.println(repository.findByLastName("Obama"));
            System.out.println(repository.findByLastName("Bush"));
        };
    }

}
