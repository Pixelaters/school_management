package za.ac.cput.controller;
/* Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 15 June 2022
  School Management
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.StudentAddress;
import za.ac.cput.service.impl.StudentAddressIService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school_management/studentAddress/")
@Slf4j
public class StudentAddressController {
    private final StudentAddressIService studentAddressIService;

    @Autowired
    public StudentAddressController(StudentAddressIService studentAddressIService){
        this.studentAddressIService = studentAddressIService;
    }

    @PostMapping("save_StudentAddress")
    public ResponseEntity<StudentAddress> create(@Valid @RequestBody StudentAddress saveStudentAddress){
        log.info("Save Request: {}",saveStudentAddress);

        try {
            StudentAddress studentAddress = studentAddressIService.create(saveStudentAddress);
            return ResponseEntity.ok(studentAddress);

        } catch(IllegalArgumentException a){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, a.getMessage());
        }
    }

    @GetMapping("readStudentAddress/{studId}")
    public ResponseEntity<StudentAddress> read(@PathVariable String studId){
        log.info("Read Request: {}",studId);

        try {
            StudentAddress readStudentAddress = studentAddressIService.read(studId);
            return ResponseEntity.ok(readStudentAddress);
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }

    }

    @DeleteMapping("deleteStudentAddress/{studId}")
    public ResponseEntity<StudentAddress> delete(@PathVariable String studId){
        log.info("Delete Request: {}",studId);

        this.studentAddressIService.delete(studId);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("getAllStudentAddresses")
    public ResponseEntity<List<StudentAddress>> getAll(){
        List<StudentAddress> listSA = this.studentAddressIService.getAll();
        return ResponseEntity.ok(listSA);
    }

}
