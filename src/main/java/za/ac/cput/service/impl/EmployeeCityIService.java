/* EmployeeCityIService.java
Service Interface class for the EmployeeCityIService
Author: Ongezwa Gwaza (211272183)
Date: 17 June 2022
*/
package za.ac.cput.service.impl;

import java.util.List;

import za.ac.cput.entity.Name;

public interface EmployeeCityIService {
    List<Name> findEmployeeNamesByCityId(String id);
    
}
