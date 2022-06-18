package za.ac.cput.service;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Employee;
import za.ac.cput.repository.EmployeeIRepository;
import za.ac.cput.service.impl.EmployeeIService;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class EmployeeService implements EmployeeIService {

    private final EmployeeIRepository employeeIRepository;

    //constructor
    @Autowired
    public EmployeeService(EmployeeIRepository employeeIRepository) {
        this.employeeIRepository = employeeIRepository;
    }

    //save an employee
    @Override
    public Employee create(Employee employee) {
            return this.employeeIRepository.save(employee);

    }

    //read an employee by id
    @Override
    public Employee read(String employeeId) {
        return this.employeeIRepository.getReferenceById(employeeId);
    }

    //delete an employee by id
    @Override
    public void delete(String employeeId) {
        this.employeeIRepository.deleteById(employeeId);
    }

    //get all employees
    @Override
    public List<Employee> getAll() {
        return this.employeeIRepository.findAll();
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeIRepository.findEmployeeByEmail(email);
    }
}
