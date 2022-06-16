package za.ac.cput.service.impl;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */
import za.ac.cput.entity.Employee;

//import java.util.List;
import java.util.*;

public interface EmployeeIService extends IService<Employee,String>{

    public List<Employee> getAll();
}
