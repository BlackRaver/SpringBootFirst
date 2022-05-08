package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping (path = "api/v1/student")
public class StudentController {

    @GetMapping
    public List<Student> hello(){
        return List.of(
                new Student(
                        1L,
                        "Wiktor",
                        "wito.w@wp.pl",
                        LocalDate.of(2001, Month.FEBRUARY, 3),
                        21
                )
        );
    }
}
