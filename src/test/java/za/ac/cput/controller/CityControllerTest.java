/* CityController.java
 Test class for the City Controller
Author: Ongezwa Gwaza (211272183)
Date: 17 June 2022
*/
package za.ac.cput.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.City;
import za.ac.cput.factory.CityFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class CityControllerTest {
    @LocalServerPort private int portNo;
    @Autowired private CityController cityController;
    @Autowired private TestRestTemplate testRestTemplate;
    private City city;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(cityController);
        this.city = CityFactory.buildCity("121","breyton@gmail.com",null);
        this.urlBase = "http://localhost:" + this.portNo + "/school_management/cities/";

    }

    @Test
    void a_create() {
       String url = urlBase + "create";
        System.out.println(url);

        ResponseEntity<City> responseEntity = this.testRestTemplate
                .postForEntity(url,this.city,City.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );

    }

    @Test
    void b_read() {
        String url = urlBase + "read/" + city.getId();
        ResponseEntity<City> responseEntity = this.testRestTemplate
                .getForEntity(url,City.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
    }

    @Test
    void c_delete() {
        String url = urlBase + "delete/" + city.getId();
        this.testRestTemplate.delete(url);

        //add some unit tests here

    }

    @Test
    void d_getAll() {
        String url = urlBase + "getAllCities";
        System.out.println(url);

        ResponseEntity<City[]> responseEntity = this.testRestTemplate
                .getForEntity(url,City[].class);

        System.out.println(Arrays.asList(responseEntity.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0)
        );

    }
    
}
