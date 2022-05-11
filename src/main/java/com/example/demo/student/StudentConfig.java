package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
            return args -> {
                Student wiktor = new Student(
                        "Wiktor",
                        "wito.w@wp.pl",
                        LocalDate.of(2001, FEBRUARY, 3),
                        21
                );

                Student Slawomir = new Student(
                        "Sławomir",
                        "slawek1928@onet.pl",
                        LocalDate.of(2000, MARCH, 4),
                        22
                );

                repository.saveAll(
                        List.of(wiktor,Slawomir)
                );
            };
    }
}
