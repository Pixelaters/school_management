package za.ac.cput.service.impl;

import za.ac.cput.entity.Country;

import java.util.List;

public interface CountryService extends IService<Country, String> {

    public List<Country> getAll();

}
