package za.ac.cput.service.impl;

import za.ac.cput.entity.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAll();

    Country create(Country country);

    Country read(String countryId);

    void delete(String countryId);
}
