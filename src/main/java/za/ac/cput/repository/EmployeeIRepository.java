package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Employee;

/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */
@Repository
public interface EmployeeIRepository extends JpaRepository<Employee,String> {

    Employee findEmployeeByEmail(String email);
    //@Query(value = "SELECT e FROM Employee WHERE e.email = ?1",nativeQuery = true)
}
