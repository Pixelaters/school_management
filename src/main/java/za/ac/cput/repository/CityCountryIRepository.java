package za.ac.cput.repository;
/*
Ziyaad Petersen
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.City;

public interface CityCountryIRepository extends JpaRepository<City, String> {

    //City findByCityIdAndCountryId(String cityId, String countryId);
    //List<City> findByCityIdAndCountryId(String cityId, String countryId);


//    @Query("SELECT City.name FROM City, Country co where co.id= :countryId")
//    void findByCityByCountryId(@Param("countryId") String countryId);
}
