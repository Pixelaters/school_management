package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.StudentAddress;
import za.ac.cput.repository.StudentAddressIRepository;
import za.ac.cput.service.impl.StudentAddressIService;

import java.util.*;

/*
*  Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
* */
@Service
public class StudentAddressService implements StudentAddressIService {

    private  StudentAddressIRepository studentAddressIRepository;

    @Autowired
    public StudentAddressService (StudentAddressIRepository studentAddressIRepository){
        this.studentAddressIRepository = studentAddressIRepository;
    }

    @Override
    public StudentAddress create(StudentAddress studentAddress){
        return this.studentAddressIRepository.save(studentAddress);
    }

    @Override
    public StudentAddress read(String studentId){
        return this.studentAddressIRepository.getReferenceById(studentId);

    }

    @Override
    public void delete(String studentId){
    this.studentAddressIRepository.deleteById(studentId);
    }

    @Override
    public List<StudentAddress> getAll() {
        return this.studentAddressIRepository.findAll();
    }


}
