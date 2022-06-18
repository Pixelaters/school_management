package za.ac.cput.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.City;
import za.ac.cput.repository.CityRepository;
import za.ac.cput.repository.CityRepository;
import za.ac.cput.service.CityService;
import za.ac.cput.service.CityService;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class CityAPI {


    private final CityService cityService;
    private final CityRepository cityRepository;

    @Autowired
    public CityAPI(CityService cityService, CityRepository cityRepository) {
        this.cityService = cityService;
        this.cityRepository = cityRepository;
    }

    public City create(City city) {
        Optional<City> cityID = cityRepository.findById(city.getId());

        //if the id is already in use, it should output a message that says that the id is already in use
        if(cityID.isPresent()){
            throw new IllegalStateException("ID already exists");
        }
        return this.cityRepository.save(city);
    }


    public City read(City city) {
        Optional<City> cityId = cityRepository.findById(city.getId());

            if (cityId.isEmpty()) {
                throw new IllegalStateException("City not found");
            }
        //returns name
        return this.cityService.read(city.getName());
    }

    public City delete(City toDelete){
        Optional<City> cityId = cityRepository.findById(toDelete.getId());

        //if the id exists in the database
        //delete city by that id
        if(cityId.isPresent()){
            this.cityService.delete(toDelete.getId());

        }else {
            //returns if the id does not exists in the database
            throw new IllegalStateException("City not found");
        }
            return toDelete;
    }

}
