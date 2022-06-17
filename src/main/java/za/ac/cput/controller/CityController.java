package za.ac.cput.controller;

import za.ac.cput.entity.City;
import za.ac.cput.service.impl.CityIService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/school-management/cities")
public class CityController {

    @Autowired
    private CityIService cityService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> createCity(@Valid @RequestBody City city) {
        try {
            City newCity = cityService.create(city);
            return ResponseEntity.ok(newCity);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @GetMapping("read/{cityId}")
    public ResponseEntity<City> read(@PathVariable String cityId){

        try{
            City city = cityService.read(cityId);
            if(city ==  null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(city);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("delete/{cityId}")
    public ResponseEntity<Void> delete(@PathVariable String cityId){

        try {
            City city = cityService.read(cityId);
            if(city ==  null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            this.cityService.delete(cityId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    
    }

    @PutMapping(value="/update/{cityId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> updateCity( @PathVariable String cityId,@Valid @RequestBody City city) {
        try {
            City newCity = cityService.update(city);
            return ResponseEntity.ok(newCity);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> getAll(){
        List<City> cities = cityService.getAll();
        return ResponseEntity.ok(cities);
    }

    
}
