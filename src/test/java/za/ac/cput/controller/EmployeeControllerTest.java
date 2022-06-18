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
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.NameFactory;

import java.util.Arrays;
import java.util.Objects;

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
        this.employee = EmployeeFactory.builder("121","breyton@gmail.com",
                NameFactory.buildName("Breyton","Sean","Ernstzen"));
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
                () -> assertNotNull(responseEntity.getBody()),
                () -> assertSame("121",employee.getStaffId()),
                () -> assertSame("breyton@gmail.com",employee.getEmail()),
                () -> assertSame("Breyton",employee.getName().getFirstName()),
                () -> assertSame("Sean",employee.getName().getMiddleName()),
                () -> assertSame("Ernstzen",employee.getName().getLastName())
        );

    }

    @Test
    void b_read() {
        String url = urlBase + "readEmployee/" + employee.getStaffId();
        ResponseEntity<Employee> responseEntity = this.testRestTemplate
                .getForEntity(url,Employee.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()),
                () -> assertSame("121",employee.getStaffId()),
                () -> assertSame("breyton@gmail.com",employee.getEmail()),
                () -> assertSame("Breyton",employee.getName().getFirstName()),
                () -> assertSame("Sean",employee.getName().getMiddleName()),
                () -> assertSame("Ernstzen",employee.getName().getLastName())
        );
    }

    @Test
    void c_delete() {
        String url = urlBase + "deleteEmployee/" + employee.getStaffId();
        this.testRestTemplate.delete(url);

        assertAll(
                () -> assertSame("121",employee.getStaffId()),
                () -> assertSame("breyton@gmail.com",employee.getEmail()),
                () -> assertSame("Breyton",employee.getName().getFirstName()),
                () -> assertSame("Sean",employee.getName().getMiddleName()),
                () -> assertSame("Ernstzen",employee.getName().getLastName())
        );
        System.out.println("Deletion success...");

    }

    @Test
    void d_getAll() {
        String url = urlBase + "getAllEmployees";
        System.out.println(url);

        ResponseEntity<Employee[]> responseEntity = this.testRestTemplate
                .getForEntity(url,Employee[].class);

        System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0),
                () -> assertNotNull(responseEntity)
        );

        System.out.println("Test passed...");

    }

    @Test
    void e_getByEmail(){
        String url = urlBase + "getEmpByEmail";
        System.out.println(url);

        ResponseEntity<Employee[]> responseEntity = this.testRestTemplate
                .getForEntity(url,Employee[].class);


        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity)
        );

        System.out.println("Test passed");
    }
}