package za.ac.cput.service;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.repository.EmployeeAddressIRepository;
import za.ac.cput.service.impl.EmployeeAddressIService;

import java.util.List;

@Service
public class EmployeeAddressService implements EmployeeAddressIService {

    private final EmployeeAddressIRepository employeeAddressIRepository;

    //constructor
    @Autowired
    public EmployeeAddressService(EmployeeAddressIRepository employeeAddressIRepository) {
        this.employeeAddressIRepository = employeeAddressIRepository;
    }

    //add an employee address
    @Override
    public EmployeeAddress create(EmployeeAddress employeeAddress) {
        return this.employeeAddressIRepository.save(employeeAddress);
    }

    //read an employee address by id
    @Override
    public EmployeeAddress read(String employeeId) {
        return this.employeeAddressIRepository.getReferenceById(employeeId);
    }

    //delete an employee address by id
    @Override
    public void delete(String employeeId) {
        this.employeeAddressIRepository.deleteById(employeeId);
    }

    //get all employee addresses
    @Override
    public List<EmployeeAddress> getAll() {
        return this.employeeAddressIRepository.findAll();
    }
}
