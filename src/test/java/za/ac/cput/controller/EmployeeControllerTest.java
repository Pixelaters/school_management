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
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmployeeControllerTest {
    @LocalServerPort private int portNo;
    @Autowired private EmployeeController employeeController;
    @Autowired private TestRestTemplate testRestTemplate;
    private Employee employee;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(employeeController);
        this.employee = EmployeeFactory.builder("121","breyton@gmail.com",null);
        this.urlBase = "http://localhost:" + this.portNo + "/school_management/employee/";

    }

    @Test
    void a_create() {
       String url = urlBase + "save_employee";
        System.out.println(url);

        ResponseEntity<Employee> responseEntity = this.testRestTemplate
                .postForEntity(url,this.employee,Employee.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );

    }

    @Test
    void b_read() {
        String url = urlBase + "readEmployee/" + employee.getStaffId();
        ResponseEntity<Employee> responseEntity = this.testRestTemplate
                .getForEntity(url,Employee.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
    }

    @Test
    void c_delete() {
        String url = urlBase + "deleteEmployee/" + employee.getStaffId();
        this.testRestTemplate.delete(url);

        //add some unit tests here

    }

    @Test
    void d_getAll() {
        String url = urlBase + "getAllEmployees";
        System.out.println(url);

        ResponseEntity<Employee[]> responseEntity = this.testRestTemplate
                .getForEntity(url,Employee[].class);

        System.out.println(Arrays.asList(responseEntity.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0)
        );

    }
}