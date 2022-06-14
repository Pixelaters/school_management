package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Employee;
import za.ac.cput.repository.EmployeeIRepository;
import za.ac.cput.service.impl.EmployeeIService;

import java.util.List;
import java.util.Optional;

/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */
@Service
public class EmployeeService implements EmployeeIService {

    private final EmployeeIRepository employeeIRepository;

    @Autowired
    public EmployeeService(EmployeeIRepository employeeIRepository) {
        this.employeeIRepository = employeeIRepository;
    }

    @Override
    public Employee create(Employee employee) {
        return this.employeeIRepository.save(employee);
    }

    @Override
    public Employee read(String employeeId) {
        return this.employeeIRepository.getById(employeeId);
    }

    @Override
    public void delete(String employeeId) {
        this.employeeIRepository.deleteById(employeeId);
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeIRepository.findAll();
    }
}
