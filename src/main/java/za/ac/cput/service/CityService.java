/* CityService.java
Service Interface class for the City
Author: Ongezwa Gwaza (211272183)
Date: 14 June 2022
*/
package za.ac.cput.service;

import java.util.List;

import za.ac.cput.entity.City;

public interface CityService extends IService<City, String>  {
    List<City> getAll();
}