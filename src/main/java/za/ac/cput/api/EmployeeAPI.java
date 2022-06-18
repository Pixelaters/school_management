package za.ac.cput.api;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Employee;
import za.ac.cput.repository.EmployeeIRepository;
import za.ac.cput.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class EmployeeAPI {
    private final EmployeeService employeeService;
    private final EmployeeIRepository employeeIRepository;

    @Autowired
    public EmployeeAPI(EmployeeService employeeService, EmployeeIRepository employeeIRepository) {
        this.employeeService = employeeService;
        this.employeeIRepository = employeeIRepository;
    }

    public Employee create(Employee employee) {
        Optional<Employee> empID = employeeIRepository.findById(employee.getStaffId());
        Optional<Employee> newEmployee = Optional.ofNullable(employeeIRepository.findEmployeeByEmail(employee.getEmail()));

        //first checks if employee is present/exists with a specific email
        //if employee exists with that email, then it should return a message that an email is already in use
        if (newEmployee.isPresent()) {
            throw new IllegalStateException("Email already exists");
        }
        //checks if an empID is already exists in the database
        //if the id is already in use, it should output a message that says that the id is already in use
        if(empID.isPresent()){
            throw new IllegalStateException("ID already exists");
        }
        return this.employeeIRepository.save(employee);
    }


    public Employee read(Employee getEmployee) {
        Optional<Employee> staffID = employeeIRepository.findById(getEmployee.getStaffId());
        //Optional<Employee> email = Optional.ofNullable(employeeIRepository.findEmployeeByEmail(getEmployee.getEmail()));

            //checks if staff id exists. then returns the email
            if (staffID.isEmpty()) {
                throw new IllegalStateException("Employee not found");
            }
        //returns name
        return this.employeeService.read(getEmployee.getName() + getEmployee.getEmail());
    }

    public Employee delete(Employee toDelete){
        Optional<Employee> staffID = employeeIRepository.findById(toDelete.getStaffId());

        //if the id exists in the database
        //delete employee by that id
        if(staffID.isPresent()){
            this.employeeService.delete(toDelete.getStaffId());

        }else {
            //returns if the id does not exists in the database
            throw new IllegalStateException("Employee not found");
        }
            return toDelete;
    }

}
