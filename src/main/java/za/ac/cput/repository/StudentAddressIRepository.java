package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.StudentAddress;
/*
 Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
*/
@Repository
public interface StudentAddressIRepository extends JpaRepository<StudentAddress , String> {
    StudentAddress findStudentAddressByCountry(String country);
}
