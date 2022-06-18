package za.ac.cput.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.City;
import za.ac.cput.entity.Country;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.NameFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CityAPITest {

    @Autowired
    private CityAPI cityAPI;

    private City city;
    private City city1;
    private Country country;

    @BeforeEach
    void setUp() {
        country = new Country.Builder().id("sa").name("South Africa").build();
        city = CityFactory.buildCity("1", "Durban", country);
        city1 = CityFactory.buildCity("2", "Joburg", country);
    }

    @Test
    void a_create() {
        city = this.cityAPI.create(this.city);
        city1 = this.cityAPI.create(this.city1);

        assertAll(
                () -> assertNotNull(city),
                () -> assertNotNull(city1),
                () -> assertNotSame(city, city1),
                () -> assertSame("Joburg", city1.getName()));
    }

    @Test
    void b_read() {
        city = this.cityAPI.read(this.city);

        assertAll(
                () -> assertNotNull(city),
                () -> assertNotSame(city, city1));

        System.out.println("Read success...");
    }

    @Test
    void c_delete() {
        city1 = this.cityAPI.delete(this.city1);

        assertAll(
                () -> assertNotNull(city1),
                () -> assertSame("Joburg", city1.getName()),
                () -> assertSame("2", city1.getId()),
                () -> assertSame("sa", country.getId()));

        System.out.println("Deletion success...");
    }
}
