package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Employee;
import za.ac.cput.repository.EmployeeIRepository;
import za.ac.cput.service.EmployeeService;

import java.util.Optional;

/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */

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

        if (newEmployee.isPresent()) {
            throw new IllegalStateException("Email already exists");
        }
        if(empID.isPresent()){
            throw new IllegalStateException("ID already exists");
        }
        return this.employeeIRepository.save(employee);
    }


    public ResponseEntity<Employee> read(Employee employee) {
        Optional<Employee> staffID = Optional.ofNullable(this.employeeService.read(employee.getStaffId()));

        try {
            //checks if staff id exists. then returns the email
            if (staffID.isPresent()) {
                return ResponseEntity.ok(employeeService.read(employee.getEmail()));

            }

        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee not found");
        }
        //returns name
        return ResponseEntity.ok(employeeService.read(employee.getName().getFirstName()));
    }
}
