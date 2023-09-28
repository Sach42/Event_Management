package com.sachin.Event.Management.controller;

import com.sachin.Event.Management.Model.Department;
import com.sachin.Event.Management.Model.Student;
import com.sachin.Event.Management.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public  String AddStudent(@Valid @RequestBody Student student){
        return studentService.AddStudent(student);
    }

    @PutMapping("/{id}/department")
    public String UpdateStudentDepartment(@PathVariable Long id, @RequestParam Department department){
            return  studentService.UpdateStudentDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}
