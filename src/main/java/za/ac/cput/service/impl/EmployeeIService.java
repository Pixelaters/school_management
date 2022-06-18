package za.ac.cput.service.impl;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.ac.cput.domain.Employee;

//import java.util.List;
import java.util.*;

public interface EmployeeIService extends IService<Employee,String>{

    @Query("SELECT Employee.name FROM Employee WHERE Employee.email = :email")
    public Employee findByEmail(@Param("email") String email);

    public List<Employee> getAll();
}
