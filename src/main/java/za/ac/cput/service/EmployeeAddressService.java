package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.EmployeeAddress;
import za.ac.cput.repository.EmployeeAddressIRepository;
import za.ac.cput.service.impl.EmployeeAddressIService;

import java.util.List;

/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */
@Service
public class EmployeeAddressService implements EmployeeAddressIService {

    private final EmployeeAddressIRepository employeeAddressIRepository;

    @Autowired
    public EmployeeAddressService(EmployeeAddressIRepository employeeAddressIRepository) {
        this.employeeAddressIRepository = employeeAddressIRepository;
    }

    @Override
    public EmployeeAddress create(EmployeeAddress employeeAddress) {
        return this.employeeAddressIRepository.save(employeeAddress);
    }

    @Override
    public EmployeeAddress read(String employeeId) {
        return this.employeeAddressIRepository.getReferenceById(employeeId);
    }

    @Override
    public void delete(String employeeId) {
        this.employeeAddressIRepository.deleteById(employeeId);
    }

    @Override
    public List<EmployeeAddress> getAll() {
        return this.employeeAddressIRepository.findAll();
    }
}
