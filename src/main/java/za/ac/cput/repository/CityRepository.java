/* CityRepository.java
Repository interface for the City
Author: Ongezwa Gwaza (211272183)
Date: 14 June 2022
*/
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.ac.cput.entity.City;


@Repository
public interface CityRepository extends JpaRepository<City, String> {
    City findCityByName(String name);

}