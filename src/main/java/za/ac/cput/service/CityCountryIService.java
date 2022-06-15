package za.ac.cput.service;

import za.ac.cput.entity.City;
import za.ac.cput.entity.Country;

import java.util.List;

public interface CityCountryIService
{
    //City findByCityIdAndCountryId(String cityId, String countryId);
    List<City> findByCityIdAndCountryId(String cityId, String countryId);
}
