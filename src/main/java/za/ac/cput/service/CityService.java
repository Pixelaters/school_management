package za.ac.cput.service;

import java.util.List;

import za.ac.cput.entity.City;

public interface CityService extends IService<City, String>  {
    List<City> getAll();
}