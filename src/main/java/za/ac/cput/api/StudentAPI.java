package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Student;
import za.ac.cput.entity.StudentAddress;
import za.ac.cput.repository.StudentAddressIRepository;
import za.ac.cput.repository.StudentIRepository;
import za.ac.cput.service.StudentAddressService;
import za.ac.cput.service.StudentService;

import java.util.Optional;

/* Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 16 June 2022
  School Management
 */
@Component
public class StudentAPI {
    private StudentService studentService;
    private StudentIRepository studentIRepository;

    private StudentAddressService studentAddressService;
    private StudentAddressIRepository studentAddressIRepository;

    @Autowired
    public StudentAPI(StudentService studentService, StudentIRepository studentIRepository,StudentAddressService studentAddressService, StudentAddressIRepository studentAddressIRepository){
        this.studentService = studentService;
        this.studentIRepository = studentIRepository;
        this.studentAddressService = studentAddressService;
        this.studentAddressIRepository = studentAddressIRepository;

    }

    public Student create(Student student){
        Optional<Student> studId = studentIRepository.findById(student.getStudentId());
        Optional<Student> studentLastName = Optional.ofNullable(studentIRepository.findStudentByLastName(student.getName().getLastName()));

    if (studentLastName.isPresent()){
        throw new IllegalStateException("LastName was not found");
    }
    if (studId.isPresent()){
        throw new IllegalStateException("LastName not found");
    }

    return this.studentIRepository.save(student);
    }

    public StudentAddress create(StudentAddress studentAddress){
        Optional<StudentAddress> studId = studentAddressIRepository.findById(studentAddress.getStudentId());
        Optional<StudentAddress> studentCountry = Optional.ofNullable(studentAddressIRepository.findStudentAddressByCountry(studentAddress.getAddress().getCity().getCountry().getName()));

        if (studentCountry.isPresent()){
            throw new IllegalStateException("Country was not found");
        }

        if (studId.isPresent()){
            throw new IllegalStateException("ID was not Found");
        }
        return this.studentAddressIRepository.save(studentAddress);
    }

    public ResponseEntity<Student> read(Student student){
        Optional<Student> studId = Optional.ofNullable(this.studentService.read(student.getStudentId()));

        try {


        if (studId.isPresent()){
            return ResponseEntity.ok(studentService.read(student.getName().getLastName()));
        }

    } catch(IllegalArgumentException e){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Student last name not found");
        }
        // returns LastName of student
        return ResponseEntity.ok(studentService.read(student.getName().getLastName()));
    }

    public ResponseEntity<StudentAddress> read(StudentAddress studentAddress){
        Optional<StudentAddress> studAddId = Optional.ofNullable(this.studentAddressService.read(studentAddress.getStudentId()));

        try {
            if (studAddId.isPresent()){
                return ResponseEntity.ok(studentAddressService.read(studentAddress.getAddress().getCity().getCountry().getName()));
            }


        }catch (IllegalArgumentException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Student Country was not found");
        }

        // return Country of Student
        return ResponseEntity.ok(studentAddressService.read(studentAddress.getAddress().getCity().getCountry().getName()));
    }


}
