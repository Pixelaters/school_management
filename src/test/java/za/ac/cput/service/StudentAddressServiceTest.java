package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.entity.StudentAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.repository.StudentAddressIRepository;

import static org.junit.jupiter.api.Assertions.*;

/*Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
* */

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class StudentAddressServiceTest {
    @Mock
    private StudentAddressIRepository studentAddressIRepository;
    StudentAddressService studentAddressService;

    private static StudentAddress studentAddress1, studentAddress2;


    @BeforeEach
    void setUp(){
        studentAddressService = new StudentAddressService(studentAddressIRepository);


        studentAddress1 = new StudentAddress.Builder()
                .studentId("287564125")
                .address(AddressFactory.build("","","95","Mavericks",4567
                        , CityFactory.buildCity("1234","Pretoria",
                                CountryFactory.builder("1","South Africa")) ))
                .build();

        studentAddress2 = new StudentAddress.Builder()
                .studentId("287564503")
                .address(AddressFactory.build("A1","James","6969","Lakers",2330
                        , CityFactory.buildCity("1235","KZN",
                                CountryFactory.builder("1","South Africa")) ))
                .build();
    }

    @Test
    void a_create(){
        studentAddressIRepository.save(studentAddress1);
        studentAddressIRepository.save(studentAddress2);


        assertAll(
                () -> assertNotNull(studentAddress1.getStudentId()),
                () -> assertNotNull(studentAddress2.getStudentId()),
                () -> assertNotNull(studentAddress1.getAddress()),
                () -> assertNotNull(studentAddress2.getAddress())
        );

        System.out.println("Students Address added....");
    }

    @Test
    void b_read() {
        studentAddressIRepository.getReferenceById(studentAddress1.getStudentId());
        studentAddressIRepository.getReferenceById(studentAddress2.getStudentId());

        assertAll(
                () -> assertNotNull(studentAddress1.getStudentId()),
                () -> assertNotNull(studentAddress2.getStudentId()),
                () -> assertNotSame(studentAddress1.getStudentId(),studentAddress2.getStudentId()),
                () -> assertNotEquals(studentAddress1.getStudentId(),studentAddress2.getStudentId())
        );
        System.out.println(studentAddress1.toString());
        System.out.println(studentAddress2.toString());
    }

    @Test
    void c_delete() {
        studentAddressIRepository.deleteById(studentAddress1.getStudentId());
        studentAddressIRepository.deleteById(studentAddress2.getStudentId());

        assertAll(
                () -> assertNotNull(studentAddress1.getStudentId()),
                () -> assertNotNull(studentAddress2.getStudentId()),
                () -> assertNotSame(studentAddress1.getStudentId(),studentAddress2.getStudentId()),
                () -> assertNotEquals(studentAddress1.getStudentId(),studentAddress2.getStudentId())
        );

        System.out.println("Deletion successful...");
    }

    @Test
    void d_getAll() {
        System.out.println(studentAddressIRepository.findAll());
    }


}

