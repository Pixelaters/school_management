package za.ac.cput.controller;
/*Breyton Ernstzen (217203027)
        ADP3 - June Assessment 2022
        Date: 14 June 2022
        School Management
        */
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
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.factory.EmployeeAddressFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmployeeAddressControllerTest {
    @LocalServerPort private int portNo;
    @Autowired EmployeeAddressController employeeAddressController;
    @Autowired private TestRestTemplate testRestTemplate;

    private EmployeeAddress employeeAddress;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(employeeAddressController);
        this.employeeAddress = EmployeeAddressFactory.builder("121", AddressFactory.build("U123",
                "Newlands Estate","124","Ben Drive Ave",7310,
                CityFactory.buildCity("P40","Pretoria", CountryFactory.builder("RSA-P40",
                        "South Africa"))));
        this.urlBase = "http://localhost:" + this.portNo + "/school_management/employeeAddress/";
    }

    @Test
    void a_create() {
        String url = urlBase + "save_EmployeeAddress";
        System.out.println(url);

        ResponseEntity<EmployeeAddress> responseEntity = this.testRestTemplate
                .postForEntity(url,this.employeeAddress,EmployeeAddress.class);
        System.out.println(responseEntity);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
    }

    @Test
    void b_read() {
        String url = urlBase + "readEmployeeAddress/" + employeeAddress.getStaffId();

        ResponseEntity<EmployeeAddress> responseEntity = this.testRestTemplate
                .getForEntity(url,EmployeeAddress.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );

    }

    @Test
    void c_delete() {
        String url = urlBase + "deleteEmployeeAddress/" + employeeAddress.getStaffId();
        this.testRestTemplate.delete(url);

        assertAll(
                () -> assertNotNull(employeeAddress),
                () -> assertSame("121", employeeAddress.getStaffId())
                );
    }

    @Test
    void d_getAll() {
        String url = urlBase + "getAllEmployeeAddresses";
        System.out.println(url);

        ResponseEntity<EmployeeAddress[]> responseEntity = this.testRestTemplate
                .getForEntity(url,EmployeeAddress[].class);

        System.out.println(Arrays.asList(responseEntity.getBody()));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0)
        );


    }
}