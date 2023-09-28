package com.sachin.Event.Management.Service;

import com.sachin.Event.Management.Model.Department;
import com.sachin.Event.Management.Model.Student;
import com.sachin.Event.Management.Repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepo studentRepo;

    public String AddStudent(Student student) {
        studentRepo.save(student);
        return "added";
    }

    public String UpdateStudentDepartment(Long id, Department department) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            student.setDepartment(department);
            studentRepo.save(student);
            return "department updated";
        }
        return "id not found";
    }

    public String deleteStudent(Long id) {
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return "id deleted";
        }
        return "id not found...!";
    }

    public List<Student> getAllStudents() {
        return (List<Student>)studentRepo.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }
}
