package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.EmployeeAddress;

import java.util.List;

/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
@Repository
public interface EmployeeAddressIRepository extends JpaRepository<EmployeeAddress,String> {

   List<EmployeeAddress> findByAddress_CityId(String cityId);
}
