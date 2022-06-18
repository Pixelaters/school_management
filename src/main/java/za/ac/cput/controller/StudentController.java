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
import za.ac.cput.domain.Student;
import za.ac.cput.service.impl.StudentIService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school_management/student/")
@Slf4j
public class StudentController {

    private final StudentIService studentIService;

    @Autowired
    StudentController(StudentIService studentIService) {
        this.studentIService = studentIService;
    }

    @PostMapping("save_student")
    public ResponseEntity<Student> create(@Valid @RequestBody Student saveStudent){
        log.info("Save request: {}",saveStudent);

        try {
            Student newStudent = studentIService.create(saveStudent);
            return ResponseEntity.ok(newStudent);
        } catch(IllegalArgumentException iae){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, iae.getMessage());
        }

    }

    @GetMapping("readStudent/{studId}")
    public ResponseEntity<Student> read(@PathVariable String studId){
        log.info("Read Request: {}",studId);

        try {
            Student readStudent = studentIService.read(studId);
            return ResponseEntity.ok(readStudent);
        }catch (IllegalArgumentException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,i.getMessage());
        }
    }

    @DeleteMapping("deleteStudent/{studId}")
    public ResponseEntity<Student> delete(@PathVariable String studId){
        log.info("Delete Request: {}",studId);

        this.studentIService.delete(studId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAllStudents")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> slist = this.studentIService.getAll();
        return ResponseEntity.ok(slist);
    }

}
