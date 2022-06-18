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
import za.ac.cput.entity.EmployeeAddress;
import za.ac.cput.entity.StudentAddress;
import za.ac.cput.factory.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class StudentAddressControllerTest {
    @LocalServerPort
    private int portNo;
    @Autowired
    StudentAddressController studentAddressController;
    @Autowired
    private TestRestTemplate testRestTemplate;

    private StudentAddress studentAddress;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(studentAddressController);
        StudentAddress studentAddress1 = StudentAddressFactory.build("25015435",
                AddressFactory.build("", "mavericks", "258", "Kit Kat", 1111,
                        CityFactory.buildCity("120", "Cape Town/CT",
                                CountryFactory.builder("CT/RSA", "RSA/CT"))));
        this.urlBase = "http://localhost:" + this.portNo + "/school_management/studentAddress/";
    }

    @Test
    void a_create() {
        String url = urlBase + "save_StudentAddress";
        System.out.println(url);

        ResponseEntity<StudentAddress> responseEntity = this.testRestTemplate
                .postForEntity(url, this.studentAddress, StudentAddress.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
    }

    @Test
    void b_read() {
        String url = urlBase + "readStudentAddress/" + studentAddress.getStudentId();

        ResponseEntity<StudentAddress> responseEntity = this.testRestTemplate
                .getForEntity(url, StudentAddress.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );

    }

    @Test
    void c_delete() {
        String url = urlBase + "deleteEmployeeAddress/" + studentAddress.getStudentId();
        this.testRestTemplate.delete(url);

        assertAll(
                () -> assertNotNull(studentAddress),
                () -> assertSame("25015435", studentAddress.getStudentId())
        );
    }

    @Test
    void d_getAll() {
        String url = urlBase + "getAllStudentAddresses";
        System.out.println(url);

        ResponseEntity<EmployeeAddress[]> responseEntity = this.testRestTemplate
                .getForEntity(url, EmployeeAddress[].class);

        System.out.println(Arrays.asList(responseEntity.getBody()));

        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0)
        );


    }
}