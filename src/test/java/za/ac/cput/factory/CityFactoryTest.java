/* CityFactoryTest.java
Test class for the City Factory
Author: Ongezwa Gwaza (211272183)
Date: 13 June 2022
*/
package za.ac.cput.factory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import za.ac.cput.entity.City;
import za.ac.cput.entity.Country;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.class)
public class CityFactoryTest {

    ArrayList<City> city = new ArrayList<City>();
    
    private static final Country country = new Country.Builder().id("sa").name("South Africa").build();

        country = new Country.Builder()
                .setId("sa")
                .Name("South Africa")
                .build();
    }
    private static final City city1 = CityFactory.buildCity("1", "Durban", country);

        // create city instances

        private static final City city2 = CityFactory.buildCity("2","Joburg",country);
                
        private static final City city3 =CityFactory.buildCity("3","Capetown",country);

        private static final City city4 =CityFactory.buildCity("4","Pretoria",country);

    @Test
    void a_builder() {
        city.add(city1);
        System.out.println("Added: " + city.get(0));
        city.add(city2);
        System.out.println("Added: " + city.get(1));
        city.add(city3);
        System.out.println("Added: " + city.get(2));

        assertAll(
                () -> assertNotNull(city1),
                () -> assertNotNull(city2),
                () -> assertNotNull(city3),
                () -> assertNotNull(city2.getName()),
                () -> assertNotNull(city3.getName()),
                () -> assertNotNull(city4.getName())
        );

    }

    @Test
    void b_objectEquality(){


        assertAll(
                () -> assertNotEquals(city1.getId(),city2.getId()),
                () -> assertNotEquals(city1.getName(),city2.getName()),
                () -> assertNotEquals(city1,city2),
                () -> assertEquals(city3,city4),
                () -> assertNotNull(city1),
                () -> assertNotNull(city2),
                () -> assertNotNull(city3),
                () -> assertNotNull(city4)
        );

        System.out.println("Equality test passed successfully");
    }

    @Test
    void c_objectIdentity(){

        assertAll(
                () ->  assertNotSame(city1.getId(),city2.getId()),
                () ->  assertNotSame(city1.getName(),city2.getName()),
                () ->  assertSame(city3,city4),
                () ->  assertNotNull(city1),
                () ->  assertNotNull(city2),
                () ->  assertNotNull(city3),
                () ->  assertNotNull(city4)

        );


        System.out.println("Identity test pass successfully");
    }
}
