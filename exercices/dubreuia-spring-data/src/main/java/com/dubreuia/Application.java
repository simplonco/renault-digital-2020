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
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

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
            studentRepository.deleteAll();

            System.out.println("find all");
            System.out.println(studentRepository.findAll());

            System.out.println("add barack and find all");
            Address address = new Address(151, "general leclerc", "paris");
            addressRepository.save(address);

            Student student = new Student("Barack", "Obama", LocalDate.of(1965, 7, 17), address);
            studentRepository.save(student);

            // find all
            List<Student> all = studentRepository.findAll();
            System.out.println(all);
        };
    }

}
