/* CityService.java
Service Interface class for the City
Author: Ongezwa Gwaza (211272183), Ziyaad Petersen(219083479)
Date: 14 June 2022
*/
package za.ac.cput.service.impl;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.ac.cput.domain.City;
import za.ac.cput.service.IService;

public interface CityIService extends IService<City, String>  {


    List<City> getAll();

      @Query("SELECT City.name FROM City, Country co where co.id= :countryId")
      public List<City> findByCityByCountryId(@Param("countryId") String countryId);
}