package za.ac.cput.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Student;
import za.ac.cput.entity.StudentAddress;
import za.ac.cput.factory.*;
import za.ac.cput.service.StudentAddressService;
import za.ac.cput.service.StudentService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentAPITest {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentAddressService studentAddressService;

    @Autowired
    private StudentAPI studentAPI;

    private Student student1 = StudentFactory.build("258016865","a@gmail.com",
            NameFactory.buildName("Mikey","","Johnson"));
    private StudentAddress studentAddress1 = StudentAddressFactory.build("258016865",
            AddressFactory.build("","","95","Kobe",7890,
                    CityFactory.buildCity("5","Gauteng",
                            CountryFactory.builder("1","South Africa"))));
    private Student student2 = StudentFactory.build("213456789","b@gmail.com",
            NameFactory.buildName("Jacob","Miguel","Rodriguez"));
    private StudentAddress studentAddress2 = StudentAddressFactory.build("213456789",
            AddressFactory.build("19","Kimberley","1200","Pearl",9998,
                    CityFactory.buildCity("6","Bloemfontein",
                            CountryFactory.builder("1","South Africa"))));
    @BeforeEach
    void setUp(){

    }

    @Test
    public void create(){
        student1 = this.studentAPI.create(this.student1);
        student2 = this.studentAPI.create(this.student2);
        studentAddress1 = this.studentAPI.create(this.studentAddress1);
        studentAddress2 = this.studentAPI.create(this.studentAddress2);

        assertAll(
                () -> assertNotNull(student1),
                () -> assertNotNull(studentAddress1),
                () -> assertNotNull(student2),
                () -> assertNotNull(studentAddress2)
        );


    }

    @Test
    void read(){

    }


}