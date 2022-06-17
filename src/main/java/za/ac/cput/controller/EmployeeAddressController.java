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
import za.ac.cput.entity.EmployeeAddress;
import za.ac.cput.service.impl.EmployeeAddressIService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school_management/employeeAddress/")
@Slf4j
public class EmployeeAddressController {

    private final EmployeeAddressIService employeeAddressIService;

    //constructor
    @Autowired
    public EmployeeAddressController(EmployeeAddressIService employeeAddressIService) {
        this.employeeAddressIService = employeeAddressIService;
    }

    //add employee address
    @PostMapping("save_EmployeeAddress")
    public ResponseEntity<EmployeeAddress> create(@Valid @RequestBody EmployeeAddress saveEmployeeAddress){
        log.info("Save request: {}",saveEmployeeAddress);

        try{
            EmployeeAddress employeeAddress = employeeAddressIService.create(saveEmployeeAddress);
            return ResponseEntity.ok(employeeAddress);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    //read employee address
    @GetMapping("readEmployeeAddress/{empID}")
    public ResponseEntity<EmployeeAddress> read(@PathVariable String empID){
        log.info("Read request: {}",empID);

        try{
            EmployeeAddress readEmployeeAddress = employeeAddressIService.read(empID);
            return ResponseEntity.ok(readEmployeeAddress);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    //delete employee address by id
    @DeleteMapping("deleteEmployeeAddress/{empID}")
    public ResponseEntity<EmployeeAddress> delete(@PathVariable String empID){
        log.info("Delete request: {}",empID);

        this.employeeAddressIService.delete(empID);
        return ResponseEntity.noContent().build();
    }

    //get all addresses
    @GetMapping("getAllEmployeeAddresses")
    public ResponseEntity<List<EmployeeAddress>> getAll(){
        List<EmployeeAddress> listEmployeeAddress = this.employeeAddressIService.getAll();
        return ResponseEntity.ok(listEmployeeAddress);
    }
}
