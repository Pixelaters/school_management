package za.ac.cput.service;
/*
Ethan George
Student Number : 21800430
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import za.ac.cput.entity.Country;
import za.ac.cput.repository.CountryRepository;
import za.ac.cput.service.impl.CountryService;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.class)
@SpringBootTest
public class CountryServiceTest {

    @Mock
    private static CountryRepository countryRepository;

    CountryService countryService;

    private static Country country1, country2;


    @BeforeEach
    void setUp() {
        countryService = new CountryServiceImpl(countryRepository);
        country1 = new Country.Builder()
                .setId("12")
                .Name(null)
                .build();


        country2 = new Country.Builder()
                .setId("13")
                .Name(null)
                .build();
    }

    @Test
    void a_create() {
        countryRepository.save(country1);
        countryRepository.save(country2);


        assertAll(
                () -> assertNotNull(country1.getId()),
                () -> assertNotNull(country2.getId()),
                () -> assertNotNull(country1.getName()),
                () -> assertNotNull(country2.getName())

        );

        System.out.println("Country Created");
    }


    @Test
    void b_read(){

        countryRepository.getReferenceById(country1.getId());
        countryRepository.getReferenceById(country2.getId());

        assertAll(
                () -> assertNotNull(country1.getId()),
                () -> assertNotNull(country2.getId()),
                () -> assertNotSame(country1.getId() , country2.getId()),
                () -> assertNotEquals(country1.getId() , country2.getId())
        );

        System.out.println(country1.toString());
        System.out.println(country2.toString());
    }

    @Test
    void c_delete(){
        countryRepository.deleteById(country1.getId());
        countryRepository.deleteById(country2.getId());

        assertAll(
                () -> assertNotNull(country1.getId()),
                () -> assertNotNull(country2.getId()),
                () -> assertNotSame(country1.getId() , country2.getId()),
                () -> assertNotEquals(country1.getId() , country2.getId())
        );

        System.out.println("Delete completed");
    }

    @Test
    void d_getAll(){
        System.out.println(countryRepository.findAll());
    }


}
