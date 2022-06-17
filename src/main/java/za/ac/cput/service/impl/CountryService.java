package za.ac.cput.service.impl;

import za.ac.cput.entity.Country;

import java.util.List;
/*
Ethan George
student number : 218008430
 */
public interface CountryService extends IService<Country, String> {

    public List<Country> getAll();

}
