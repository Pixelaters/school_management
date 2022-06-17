package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Country;
import za.ac.cput.repository.CountryRepository;
import za.ac.cput.service.impl.CountryService;

import java.util.Collections;
import java.util.List;

/*
Ethan George
student number : 218008430
 */
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> getAll(){
        return this.countryRepository.findAll();
    }



    @Override
    public Country create(Country country){
        return this.countryRepository.save(country);
    }

    @Override
    public Country read(String countryId){
        return this.countryRepository.getById(countryId);
    }

    @Override
    public void delete(String countryId){
        this.countryRepository.deleteAllById(Collections.singleton(countryId));
    }


}
