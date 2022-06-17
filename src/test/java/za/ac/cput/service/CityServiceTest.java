/* CityServiceTest.java
Test class for City service
Author: Ongezwa Gwaza (211272183)
Date: 16 June 2022
*/
package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import za.ac.cput.entity.City;
import za.ac.cput.entity.Country;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.repository.CityRepository;
import za.ac.cput.service.impl.CityIService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.class)
public class CityServiceTest {
  
    private static CityService cityService = CityServiceImpl.getCityService();
    private static Country country;
    private static City testCity;
    private static City city2, city3, city4;

    @BeforeAll
    public static void setUp() throws Exception {

        country = new Country.Builder().setId("sa").Name("South Africa").build();


    @Mock
    private static CityRepository cityRepository;

    CityIService cityService;
    private static Country country;
    private static City city1,city2;

    @BeforeEach
    void setUp(){
        cityService = new CityService(cityRepository);
        country = new Country.Builder().id("sa").name("South Africa").build();
        city1 = CityFactory.buildCity("1", "Durban", country);
                city2 = CityFactory.buildCity("2","Joburg",country);


    }

    @Test
    void a_create(){
        cityRepository.save(city1);
        cityRepository.save(city2);

        assertAll(
                () -> assertNotNull(city1.getId()),
                () -> assertNotNull(city2.getId()),
                () -> assertNotNull(city1.getName()),
                () -> assertNotNull(city2.getName()),
                () -> assertNotNull(city1.getCountry()),
                () -> assertNotNull(city2.getCountry())

        );

        System.out.println("Cities added....");
    }

    @Test
    void b_read() {
        cityRepository.getReferenceById(city1.getId());
        cityRepository.getReferenceById(city2.getId());

        assertAll(
                () -> assertNotNull(city1.getId()),
                () -> assertNotNull(city2.getId()),
                () -> assertNotSame(city1.getId(),city2.getId()),
                () -> assertNotEquals(city1.getId(),city2.getId())
        );

        System.out.println(city1.toString());
        System.out.println(city2.toString());
    }

    @Test
    void c_delete(){
        cityRepository.deleteById(city1.getId());
        cityRepository.deleteById(city2.getId());

        assertAll(
                () -> assertNotNull(city1.getId()),
                () -> assertNotNull(city2.getId()),
                () -> assertNotSame(city1.getId(),city2.getId()),
                () -> assertNotEquals(city1.getId(),city2.getId())

        );

        System.out.println("Deletion successful....");
    }

    @Test
    void d_getAll() {
        System.out.println(cityRepository.findAll());
    }

}
