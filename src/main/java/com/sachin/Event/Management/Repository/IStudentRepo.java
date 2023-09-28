package com.sachin.Event.Management.Repository;

import com.sachin.Event.Management.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<Student,Long> {
}
