package za.ac.cput.service.impl;

import za.ac.cput.entity.EmployeeAddress;

import java.util.List;

/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */
public interface EmployeeAddressIService extends IService<EmployeeAddress,String>{

    public List<EmployeeAddress> getAll();
}
