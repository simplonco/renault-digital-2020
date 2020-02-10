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
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLine() {
        return args -> {
            System.out.println(studentRepository.findAll());
            studentRepository.save(new Student("Alex", "Dubreuil", LocalDate.now()));
            System.out.println(studentRepository.findAll());
            System.out.println(studentRepository.findByLastName("W. Bush"));
        };
    }

}
