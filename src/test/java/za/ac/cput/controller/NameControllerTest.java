/*
Student Name: Nondumiso Gaga
Student Number: 220430853
NameControlleTestr
 */
package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Name;
import za.ac.cput.factory.NameFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NameControllerTest {

    @LocalServerPort
    private int port;
    @Autowired private NameController nameController;
    @Autowired private TestRestTemplate testTemplate;
    private Name name;
    private String url;

    @BeforeEach
    void setUp() {
        assertNotNull(nameController);
        this.name = NameFactory.buildName("Lowry","Pinky","Nakai");
        this.url = "http:localhost:" + this.port+"school_management/name/";
    }

    @Test
    void save() {
        String url1 = url + "save";
        System.out.println(url);

        ResponseEntity<Name> responseEntity = this.testTemplate
                .postForEntity(url1,this.name,Name.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
    }

    @Test
    void read() {
        String url1 = url + "read/" + name.getFirstName();
            ResponseEntity<Name> responseEntity = this.testTemplate
                .getForEntity(url1,Name.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
    }

    @Test
    void delete() {
        String url1 = url + "deleteEmployee/" + name.getFirstName();
        this.testTemplate.delete(url1);

    }

    @Test
    void getAll() {
        String url1 = url + "getAll";
        System.out.println(url1);
        ResponseEntity<Name[]> response= this.testTemplate.getForEntity(url1,Name[].class);
        System.out.println(Arrays.asList(response.getBody()));
       assertEquals(HttpStatus.OK,response.getStatusCode());
        assertTrue(response.getBody().length == 0);
    }
}