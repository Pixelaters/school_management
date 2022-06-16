package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.entity.Employee;
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

    @Autowired
    public EmployeeAPI(EmployeeService employeeService) {
        this.employeeService = employeeService;


    }

}
