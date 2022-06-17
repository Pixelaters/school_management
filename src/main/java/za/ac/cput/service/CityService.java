/* CityServiceImpl.java
Service Implementation class for the City
Author: Ongezwa Gwaza (211272183)
Date: 14 June 2022
*/
package za.ac.cput.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.entity.City;
import za.ac.cput.repository.CityRepository;
import za.ac.cput.service.impl.CityIService;

@Service
public class  CityService implements CityIService {
    private final CityRepository  cityRepository;

    @Autowired
    public CityService (CityRepository cityRepository){
    this.cityRepository = cityRepository;
    }

    @Override
    public City create(City city) {
        return this.cityRepository.save(city);
    }

    @Override
    public City read(String id) {
        return this.cityRepository.getReferenceById(id);
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


}