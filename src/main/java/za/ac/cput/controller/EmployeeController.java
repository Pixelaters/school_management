package za.ac.cput.controller;
/*Breyton Ernstzen (217203027)
        ADP3 - June Assessment 2022
        Date: 14 June 2022
        School Management
        */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.EmployeeAPI;
import za.ac.cput.entity.Employee;
import za.ac.cput.service.impl.EmployeeIService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school_management/employee/")
@Slf4j
public class EmployeeController {

    private final EmployeeIService employeeIService;
    //private final EmployeeAPI employeeAPI;

    @Autowired
    EmployeeController(EmployeeIService employeeIService) {
        this.employeeIService = employeeIService;
        //this.employeeAPI = employeeAPI;
    }

    @PostMapping("save_employee")
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee saveEmployee){
        log.info("Save request: {}",saveEmployee);

        try{
            Employee newEmployee = employeeIService.create(saveEmployee);
            return ResponseEntity.ok(newEmployee);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readEmployee/{empID}")
    public ResponseEntity<Employee> read(@PathVariable String empID){
        log.info("Read request: {}",empID);

        try {
            Employee readEmployee = employeeIService.read(empID);
            return ResponseEntity.ok(readEmployee);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("deleteEmployee/{empID}")
    public ResponseEntity<Employee> delete(@PathVariable String empID){
        log.info("Delete request: {}",empID);

        this.employeeIService.delete(empID);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("getAllEmployees")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> list = this.employeeIService.getAll();
        return ResponseEntity.ok(list);
    }
}
