package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.ac.cput.entity.City;

public interface CityCountryIRepository extends JpaRepository<City, String> {

    //City findByCityIdAndCountryId(String cityId, String countryId);
    //List<City> findByCityIdAndCountryId(String cityId, String countryId);


//    @Query("SELECT City.name FROM City, Country co where co.id= :countryId")
//    void findByCityByCountryId(@Param("countryId") String countryId);
}
