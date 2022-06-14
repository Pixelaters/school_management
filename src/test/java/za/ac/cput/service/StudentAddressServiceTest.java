package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.entity.StudentAddress;
import za.ac.cput.repository.StudentAddressIRepository;

import static org.junit.jupiter.api.Assertions.*;

/*Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
* */

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.class)
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
                .address(null)
                .build();

        studentAddress2 = new StudentAddress.Builder()
                .studentId("287564503")
                .address(null)
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

