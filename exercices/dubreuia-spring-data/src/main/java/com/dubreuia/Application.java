package com.dubreuia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

    @Autowired
    StudentRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (arg) -> {
            System.out.println(repository.findAll());
            repository.save(new Student("Alex", "Dubreuil", LocalDate.now()));
            System.out.println(repository.findAll());
            System.out.println(repository.findByLastName("Dubreuil"));
        };
    }

}
