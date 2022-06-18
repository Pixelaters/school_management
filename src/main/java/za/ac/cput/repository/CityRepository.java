/* CityRepository.java
Repository interface for the City
Author: Ongezwa Gwaza (211272183)
Date: 14 June 2022
*/
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import za.ac.cput.entity.City;

import java.util.List;


@Repository
public interface CityRepository extends JpaRepository<City, String> {
    City findCityByName(String name);

//    @Query("SELECT City.name FROM City, Country co where co.id= :countryId")
     public List<City> findCityByCountryId(@Param("countryId") String countryId);

}