package za.ac.cput.service;

/*Ziyaad Petersen
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management*/

import za.ac.cput.domain.City;

import java.util.List;

public interface CityCountryIService
{
    //City findByCityIdAndCountryId(String cityId, String countryId);
    List<City> findByCityIdAndCountryId(String cityId, String countryId);
}
