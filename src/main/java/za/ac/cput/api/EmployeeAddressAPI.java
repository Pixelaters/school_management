package za.ac.cput.api;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 16 June 2022
  School Management
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.entity.Employee;
import za.ac.cput.entity.EmployeeAddress;
import za.ac.cput.repository.EmployeeAddressIRepository;
import za.ac.cput.service.EmployeeAddressService;

import java.util.Optional;

@Component
public class EmployeeAddressAPI {

    private final EmployeeAddressService employeeAddressService;
    private final EmployeeAddressIRepository employeeAddressIRepository;

    @Autowired
    public EmployeeAddressAPI(EmployeeAddressService employeeAddressService, EmployeeAddressIRepository employeeAddressIRepository) {
        this.employeeAddressService = employeeAddressService;
        this.employeeAddressIRepository = employeeAddressIRepository;
    }

    public EmployeeAddress create(EmployeeAddress employeeAddress){
        Optional<EmployeeAddress> addEmployeeAddress = employeeAddressIRepository.findById(employeeAddress.getStaffId());

        //checks if employee id already in the database and if it belongs to an address already
        if(addEmployeeAddress.isPresent()){
            throw new IllegalArgumentException("Staff id already assigned to an address");
        }
        //save an employee address
        return this.employeeAddressIRepository.save(employeeAddress);
        }

    public EmployeeAddress read(EmployeeAddress getEmployeeAddress){
        Optional<EmployeeAddress> staffID = employeeAddressIRepository.findById(getEmployeeAddress.getStaffId());

        //checks if the existing staff id is already assigned to an address
        //if yes, return an exception
        if(staffID.isEmpty()){
            throw new IllegalArgumentException("No employee found with such address");
        }

        //return staff id and its address
        return this.employeeAddressService.read(getEmployeeAddress.getStaffId() + getEmployeeAddress.getAddress());

        }

    public EmployeeAddress delete(EmployeeAddress toDelete){
        Optional<EmployeeAddress> staffID = employeeAddressIRepository.findById(toDelete.getStaffId());

        //checks of the staff id exists.
        //if it exists, delete employee address by ID
        if(staffID.isPresent()){
            this.employeeAddressService.delete(toDelete.getStaffId());

        }else {
            //if employee not found
            throw new IllegalStateException("Employee not found");
        }
        return toDelete;
    }
    }


