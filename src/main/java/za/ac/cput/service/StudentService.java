package za.ac.cput.service;

/*
*  Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
* */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.StudentIRepository;
import za.ac.cput.service.impl.StudentIService;

import java.util.*;
@Service
public class StudentService implements StudentIService {
    private final StudentIRepository studentIRepository;

    @Autowired
    public StudentService (StudentIRepository studentIRepository){
    this.studentIRepository = studentIRepository;
    }

    @Override
    public Student create(Student student) {
        return this.studentIRepository.save(student);
    }

    @Override
    public Student read(String studentId){
        return this.studentIRepository.getReferenceById(studentId);
    }

    @Override
    public void delete(String studentId){
        this.studentIRepository.deleteById(studentId);
    }

    @Override
    public List<Student> getAll(){
        return this.studentIRepository.findAll();
    }
}
