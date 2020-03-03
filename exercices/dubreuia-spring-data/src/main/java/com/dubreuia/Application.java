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

    private final StudentRepository studentRepository;

    private final AddressRepository addressRepository;

    public Application(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

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
//            addressRepository.deleteAll();

            // save addresss
            System.out.println("add barack and find all");
            Address address = new Address(151, "general leclerc", "paris");
            addressRepository.save(address);

            // save students
            Student student = new Student("Barack", "Obama", LocalDate.of(1965, 7, 17));
            student.setAddress(address);
            address.setStudents(List.of(student));
            studentRepository.save(student);

            // select all
            List<Student> all = studentRepository.findAll();
            System.out.println(all);
        };
    }

}
