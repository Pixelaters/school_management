package za.ac.cput.controller;
/* Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 15 June 2022
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
import za.ac.cput.domain.Student;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.factory.StudentFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class StudentControllerTest {
    @LocalServerPort
    private int portNo;
    @Autowired
    private StudentController studentController;
    @Autowired private TestRestTemplate testRestTemplate;
    private Student student;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(studentController);
        Student student1 = StudentFactory.build("258016865","a@gmail.com",
                NameFactory.buildName("Mikey","","Johnson"));
        this.urlBase = "http://localhost:" + this.portNo + "/school_management/student/";

    }

    @Test
    void a_create() {
        String url = urlBase + "save_student";
        System.out.println(url);

        ResponseEntity<Student> responseEntity = this.testRestTemplate
                .postForEntity(url,this.student,Student.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()),
                () -> assertSame("258016865",student.getStudentId()),
                () -> assertSame("a@gmail.com",student.getEmail()),
                () -> assertSame("Mikey",student.getName().getFirstName()),
                () -> assertSame("",student.getName().getMiddleName()),
                () -> assertSame("Johnson",student.getName().getLastName())
        );

    }

    @Test
    void b_read() {
        String url = urlBase + "readStudent/" + student.getStudentId();
        ResponseEntity<Student> responseEntity = this.testRestTemplate
                .getForEntity(url,Student.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()),
                () -> assertSame("258016865",student.getStudentId()),
                () -> assertSame("a@gmail.com",student.getEmail()),
                () -> assertSame("Mikey",student.getName().getFirstName()),
                () -> assertSame("",student.getName().getMiddleName()),
                () -> assertSame("Johnson",student.getName().getLastName())
        );
    }

    @Test
    void c_delete() {
        String url = urlBase + "deleteStudent/" + student.getStudentId();
        this.testRestTemplate.delete(url);

        assertAll(
                () -> assertSame("258016865",student.getStudentId()),
                () -> assertSame("a@gmail.com",student.getEmail()),
                () -> assertSame("Mikey",student.getName().getFirstName()),
                () -> assertSame("",student.getName().getMiddleName()),
                () -> assertSame("Johnson",student.getName().getLastName())
        );
        System.out.println("Deletion success...");

    }

    @Test
    void d_getAll() {
        String url = urlBase + "getAllStudents";
        System.out.println(url);

        ResponseEntity<Student[]> responseEntity = this.testRestTemplate
                .getForEntity(url,Student[].class);

        System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0),
                () -> assertNotNull(responseEntity)
        );

        System.out.println("Test passed...");

    }
}