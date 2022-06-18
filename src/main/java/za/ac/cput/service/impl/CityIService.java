/* CityService.java
Service Interface class for the City
Author: Ongezwa Gwaza (211272183)
Date: 14 June 2022
*/
package za.ac.cput.service.impl;

import java.util.List;

import za.ac.cput.entity.City;
import za.ac.cput.service.IService;

public interface CityIService extends IService<City, String>  {
    List<City> getAll();

}