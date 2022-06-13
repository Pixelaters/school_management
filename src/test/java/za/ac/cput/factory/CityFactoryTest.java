/* CityFactoryTest.java
Test class for the City Factory
Author: Ongezwa Gwaza (211272183)
Date: 13 June 2022
*/
package za.ac.cput.factory;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import za.ac.cput.entity.City;
import za.ac.cput.entity.Country;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CityFactoryTest {
    private static Country country;

    @BeforeAll
    public static void setUp() throws Exception {

        country = new Country.Builder()
                .countryId("sa")
                .countryName("South Africa")
                .build();
    }

    @Test
    @DisplayName("Test Creation of a new city")
    public void createNewCityTest() {
        City city = CityFactory.buildCity("1", "Durban", country);
        assertNotNull(city);
        System.out.println("Test passed : New city created");

    }

    @Test
    @DisplayName("Test Details of created city")
    public void testCityDetails() throws Exception {
        City city = CityFactory.buildCity("2", "Pretoria", country);
        assertEquals("2", city.getId());
        assertEquals("Pretoria", city.getName());
        assertEquals(country, city.getCountry());
        System.out.println("Test passed : Details are equal");

    }

    @Test
    @DisplayName("Test copy method ")
    public void copyDetailsShouldBeTheSame() {
        City city = CityFactory.buildCity("1", "Durban", country);
        City cityCopy = new City.Builder().copy(city).build();

        assertEquals(
                city.getId(),
                cityCopy.getId());
        assertEquals(
                city.getName(),
                cityCopy.getName());
        assertEquals(
                city.getCountry(),
                cityCopy.getCountry());
        System.out.println("Test passed : copied Details are equal");

    }
}
