package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping (path = "api/v1/student")
public class StudentController {

    StudentService studentService; // reference to StudentService class to get access to StudentService methods

    @Autowired  //Dependency injection used to create an instance of StudentService
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
}
