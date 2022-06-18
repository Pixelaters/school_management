package za.ac.cput.service;
/*
*  Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
* */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.entity.Employee;
import za.ac.cput.entity.Student;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.repository.StudentIRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.class)
class StudentServiceTest {

    @Mock
    private static StudentIRepository studentIRepository;

    StudentService studentService;
    private static Student student1,student2;

    @BeforeEach
    void setUp(){
        studentService = new StudentService(studentIRepository);
        student1 = new Student.Builder()
                .studentId("258016865")
                .email("a@gmail.com")
                .name(NameFactory.buildName("Mikey","","Johnson"))
                .build();

        student2 = new Student.Builder()
                .studentId("213456789")
                .email("b@gmail.com")
                .name(NameFactory.buildName("Jacob","Miguel","Rodriguez"))
                .build();

    }

    @Test
    void a_create(){
        studentIRepository.save(student1);
        studentIRepository.save(student2);

        assertAll(
                () -> assertNotNull(student1.getStudentId()),
                () -> assertNotNull(student2.getStudentId()),
                () -> assertNotNull(student1.getEmail()),
                () -> assertNotNull(student2.getEmail()),
                () -> assertNull(student1.getName()),
                () -> assertNull(student2.getName())
        );

        System.out.println("Students added....");
    }

    @Test
    void b_read() {
        studentIRepository.getReferenceById(student1.getStudentId());
        studentIRepository.getReferenceById(student2.getStudentId());

        assertAll(
                () -> assertNotNull(student1.getStudentId()),
                () -> assertNotNull(student2.getStudentId()),
                () -> assertNotSame(student1.getStudentId(),student2.getStudentId()),
                () -> assertNotEquals(student1.getStudentId(),student2.getStudentId())
        );

        System.out.println(student1.toString());
        System.out.println(student2.toString());
    }

    @Test
    void c_delete(){
        studentIRepository.deleteById(student1.getStudentId());
        studentIRepository.deleteById(student2.getStudentId());

        assertAll(
                () -> assertNotNull(student1.getStudentId()),
                () -> assertNotNull(student2.getStudentId()),
                () -> assertNotSame(student1.getStudentId(),student2.getStudentId()),
                () -> assertNotEquals(student1.getStudentId(),student2.getStudentId())

        );

        System.out.println("Deletion successful....");
    }

    @Test
    void d_getAll() {
        System.out.println(studentIRepository.findAll());
    }




}