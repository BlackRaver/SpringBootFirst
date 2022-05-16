package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
       Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
       if(studentOptional.isPresent())
       {
           throw new IllegalStateException("Email is already taken");
       }
       studentRepository.save(student);
       // System.out.println(student);
    }

    public void deleteStudent(long id) {
        Boolean exist = studentRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("Student with given ID: "+id+" does not exist");
        }
        studentRepository.deleteById(id);
    }


}
