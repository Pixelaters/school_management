/* CityService.java
Service Interface class for the City
Author: Ongezwa Gwaza (211272183)
Date: 14 June 2022
*/
package za.ac.cput.service;

import java.util.List;

import za.ac.cput.entity.City;
import za.ac.cput.entity.Country;

public interface CityService extends IService<City, String>  {
    List<City> getAll();
    //Read class in impl package it should explain this
    City getCityByName(String name);
    City getCityByCountry(Country country);
    void deleteAll();//should only be a single unit not all records

}