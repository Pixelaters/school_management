/* EmployeeCity.java
Service class for EmployeeCity
Author: Ongezwa Gwaza (211272183)
Date: 17 June 2022
*/
package za.ac.cput.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.Employee;
import za.ac.cput.entity.EmployeeAddress;
import za.ac.cput.entity.Name;
import za.ac.cput.repository.EmployeeAddressIRepository;
import za.ac.cput.repository.EmployeeIRepository;
import za.ac.cput.service.impl.EmployeeCityIService;

public class EmployeeCityService implements EmployeeCityIService {

     private final EmployeeAddressIRepository employeeAddressIRepository;
    private final EmployeeIRepository employeeIRepository;

     @Autowired
     public EmployeeCityService(EmployeeAddressIRepository employeeAddressIRepository,EmployeeIRepository employeeIRepository) {
         this.employeeAddressIRepository = employeeAddressIRepository;
         this.employeeIRepository = employeeIRepository;
     }





    @Override
    public List<Name> findEmployeeNamesByCityId(String cityId) {
        List<Name> names =  new ArrayList();
//        try {
//            List<EmployeeAddress> employeeAddresses = employeeAddressIRepository.getEmployeeAddressesByAddress_CityId(cityId);
//            Set<String> staffIds = new HashSet<>(employeeAddresses.stream().map((employeeAddress) -> employeeAddress.getStaffId()).collect(Collectors.toList()));
//            List<Employee> employees = employeeIRepository.getEmployeesByStaffIdInSet(staffIds);
//             names = employees.stream().map((employee -> employee.getName())).collect(Collectors.toList());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        
        return names;
    }
 
}
