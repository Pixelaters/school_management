package za.ac.cput.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Country;
import za.ac.cput.service.impl.CountryService;

import java.util.List;

@RestController
@RequestMapping("school_management/country")
@Log4j2
public class CountryController {

    private final CountryService countryService;



    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCountries(){
        return ResponseEntity.ok(countryService.getAll());
    }

    @GetMapping("/{countryid}")
    public ResponseEntity<?> getCountry(@PathVariable String countryId){
        try {
            return ResponseEntity.ok(countryService.read(countryId));
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createCountry(@RequestBody Country country){
        try {
            countryService.create(country);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("deleteCountry/{countryId}")
    public ResponseEntity<?> deleteCountry(@PathVariable String countryId){

        this.countryService.delete(countryId);
        return ResponseEntity.noContent().build();
    }


}
