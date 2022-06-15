package za.ac.cput.service;

import org.junit.jupiter.api.*;

import za.ac.cput.entity.City;
import za.ac.cput.entity.Country;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.service.impl.CityServiceImpl;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.class)
public class CityServiceTest {
    private static CityService cityService = CityServiceImpl.getCityService();
    private static Country country;
    private static City testCity;
    private static City city2, city3, city4;

    @BeforeAll
    public static void setUp() throws Exception {

        country = new Country.Builder().setId("sa").setName("South Africa").build();

        testCity = CityFactory.buildCity("1", "Durban", country);

        // create city instances

        city2 = CityFactory.buildCity("2","Joburg",country);
                
        city3 =CityFactory.buildCity("3","Capetown",country);

        city4 =CityFactory.buildCity("4","Pretoria",country);
    }

    @AfterEach
    public void cleanUpEach() throws Exception {
        cityService.deleteAll();

    }

    @Test
    @DisplayName("Test get all when database is empty")
    public void getAll_if_database_isempty() {

        List<City> cities = cityService.getAll();
        System.out.println(cities);
        Boolean citiesIsEmpty = cities.isEmpty();

        assertTrue(citiesIsEmpty, "Database is empty as there are not items in the database");
        System.out.println("Test passed : Database is empty");

    }

    @Test
    @DisplayName("Test persistence of city in the database")
    public void createCity_success() {
        City city = cityService.create(testCity);
        assertNotNull(city, "The saved city should not be null");
        assertEquals(city.getId(), testCity.getId(),
                "The saved id should be equal to the id of supplied city");
        assertEquals(city.getName(), testCity.getName(),
                "The names of the saved city and supplied city should be equal");
        assertEquals(city.getCountry(), testCity.getCountry(), "The country fields should be equal");
        System.out.println("Test passed: City created and saved");

    }

    @Test
    @DisplayName("List all the cities in the database")
    public void getAll_when_database_has_values() {

        // save the cities to database
        System.out.println(cityService.getAll());
        cityService.create(city2);
        cityService.create(city3);
        cityService.create(city4);

        List<City> cities = cityService.getAll();
        assertEquals(3, cities.size(),
                "The number of elements in the database should be equal to the number of items added");
        System.out.println("Test passed : All cities listed");

    }

    @Test
    @DisplayName("Get one city by city id")
    public void read_should_find_city_by_id() {

        cityService.create(testCity);
        cityService.create(city2);
        cityService.create(city3);
        City foundCity = cityService.read(testCity.getId());
        assertEquals(foundCity, testCity, "The city found in the database should be equal to the city added");
        System.out.println("Test passed : One city read from database");
    }

    @Test
    @DisplayName("Get one city by city name")
    public void getCityByName_success() {
        // save cities
        cityService.create(testCity);
        cityService.create(city2);
        cityService.create(city3);
        // get city by name
        City foundCity = cityService.getCityByName(testCity.getName());
        assertEquals(foundCity, testCity, "The city found in the database should be equal to the city added");
        System.out.println("Test passed : City found by name");
    }

    @Test
    @DisplayName("Get one city by country")
    public void getCityByCountry_success() {
        // save cities
        cityService.create(testCity);
        cityService.create(city2);
        cityService.create(city3);
        // get city by publisher
        City foundCity = cityService.getCityByCountry(testCity.getCountry());
        assertEquals(foundCity, testCity, "The city found in the database should be equal to the city added");
        System.out.println("Test passed : City Found by country");
    }



    @Test
    @DisplayName("Delete city by id")
    public void delete() {
        // save cities
        cityService.create(testCity);
        cityService.create(city2);
        cityService.create(city3);
        // delete city
         cityService.delete(testCity.getId());
         City foundCity = cityService.read(testCity.getId());
        assertNull(foundCity, testCity.getName() + " has been deleted successfully");
        System.out.println("Test passed : Cities successfully deleted");


        // test if the other cities are still available
        List<City> cities = cityService.getAll();
        Boolean city2isPresent = cities.contains(city2);
        Boolean city3isPresent = cities.contains(city3);
        assertTrue(city2isPresent, city2.getName() + " was not deleted");
        assertTrue(city3isPresent, city3.getName() + " was not deleted");
        System.out.println("Test passed : Cities not deleted");

    }

}
