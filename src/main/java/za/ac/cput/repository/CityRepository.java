/* CityRepository.java
Repository interface for the City
Author: Ongezwa Gwaza (211272183)
Date: 14 June 2022
*/
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.ac.cput.entity.City;
import za.ac.cput.entity.Country;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
    //Country must first be found before you can use it
    // so the country function here finds your personal country record
    // and does not use the database as specified
    City findByName(String name);
    City findByCountry(Country country);
}