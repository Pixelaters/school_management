package za.ac.cput.api;
/* Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 16 June 2022
  School Management
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import za.ac.cput.entity.Student;
import za.ac.cput.entity.StudentAddress;
import za.ac.cput.factory.*;
import za.ac.cput.repository.StudentAddressIRepository;
import za.ac.cput.repository.StudentIRepository;
import za.ac.cput.service.StudentAddressService;
import za.ac.cput.service.StudentService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class StudentAPITest {
    @Autowired
    private StudentAPI studentAPI;

    private Student student1,student2;
    private StudentAddress studentAddress1,studentAddress2;





    @BeforeEach
    void setUp(){
         Student student1 = StudentFactory.build("258016865","a@gmail.com",
                NameFactory.buildName("Mikey","","Johnson"));
         StudentAddress studentAddress1 = StudentAddressFactory.build("258016865",
                AddressFactory.build("","","95","Kobe",7890,
                        CityFactory.buildCity("5","Gauteng",
                                CountryFactory.builder("1","South Africa"))));
         Student student2 = StudentFactory.build("213456789","b@gmail.com",
                NameFactory.buildName("Jacob","Miguel","Rodriguez"));
         StudentAddress studentAddress2 = StudentAddressFactory.build("213456789",
                AddressFactory.build("19","Kimberley","1200","Pearl",9998,
                        CityFactory.buildCity("6","Bloemfontein",
                                CountryFactory.builder("1","South Africa"))));

    }

    @Test
    public void a_create(){
        student1 = this.studentAPI.createStud(this.student1);
        student2 = this.studentAPI.createStud(this.student2);
        studentAddress1 = this.studentAPI.createStudAdd(this.studentAddress1);
        studentAddress2 = this.studentAPI.createStudAdd(this.studentAddress2);

        assertAll(
                () -> assertNotNull(student1),
                () -> assertNotNull(studentAddress1),
                () -> assertNotNull(student2),
                () -> assertNotNull(studentAddress2)
        );


    }

    @Test
    void b_read(){
        student1 = this.studentAPI.readLastName(this.student1);
        studentAddress1 = this.studentAPI.readStudentCountry(this.studentAddress1);
        student2 = this.studentAPI.readLastName(this.student2);
        studentAddress2 = this.studentAPI.readStudentCountry(this.studentAddress2);

        assertAll(
                () -> assertNotNull(student1),
                () -> assertNotNull(student2),
                () -> assertNotNull(studentAddress1),
                () -> assertNotNull(studentAddress2),
                () -> assertNotSame(student1,student2),
                () -> assertNotSame(studentAddress1,studentAddress2)
        );

        System.out.println("Read was successful.....");
    }

    @Test
    void delete(){

    }


}