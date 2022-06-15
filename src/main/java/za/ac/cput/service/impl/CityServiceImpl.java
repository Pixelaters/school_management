/* CityServiceImpl.java
Service Implementation class for the City
Author: Ongezwa Gwaza (211272183)
Date: 14 June 2022
*/
package za.ac.cput.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.entity.City;
import za.ac.cput.entity.Country;
import za.ac.cput.repository.CityRepository;
import za.ac.cput.service.CityService;

@Service
public class  CityServiceImpl implements CityService {

    private static CityService cityService = null;

    @Autowired
    private CityRepository cityRepository;

    public CityServiceImpl() {

    }

    public static CityService getCityService() {
        if (cityService == null) cityService = new CityServiceImpl();
        return cityService;
    }

    @Override
    public City create(City city) {
        return this.cityRepository.save(city);
    }

    @Override
    public City read(String id) {
        Optional<City> city = this.cityRepository.findById(id);
        return city.orElse(null);
    }

    @Override
    public City update(City city) {
        return this.cityRepository.save(city);
    }

    @Override
    public void delete(String id) {
        this.cityRepository.deleteById(id);
    }

    @Override
    public List<City> getAll() {
        return this.cityRepository.findAll();
    }

    @Override
    public City getCityByName(String name) {

        return this.cityRepository.findByName(name);
    }

    @Override
    public City getCityByCountry(Country country) {
        return this.cityRepository.findByCountry(country);
    }

    @Override
    public void deleteAll() {
        cityRepository.deleteAll();
        
    }
}