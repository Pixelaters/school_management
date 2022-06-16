package za.ac.cput.factory;
/* Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 11 June 2022
  School Management
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Student;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.class)
class StudentFactoryTest {

    ArrayList<Student> student = new ArrayList<>();
    private static final Student student1 = StudentFactory.build("25015435","Mat385@gmail.com",
            NameFactory.buildName("Mat","jack","Uzumaki"));
    private static final Student student2 = StudentFactory.build("28965234","Jake125@gmail.com",
            NameFactory.buildName("Jake","Jackson","Thomas"));
    private static final Student student3 = StudentFactory.build("23152687","Mike578@gmail.com",
            NameFactory.buildName("Micheal","Jermaine","Paulson"));
    private static final Student student4 = student3;

    @Test
    void a_builder(){
        student.add(student1);
        System.out.println("Added: " + student.get(0));
        student.add(student2);
        System.out.println("Added: " + student.get(1));
        student.add(student3);
        System.out.println("Added: " + student.get(2));
        assertNotNull(student);
        System.out.println("Builder passed successfully");

    }

    @Test
    void b_objectEquality(){
        assertNotEquals(student1.getStudentId(),student2.getStudentId());
        assertNotEquals(student1.getEmail(), student2.getEmail());
        assertNotEquals(student1.getName(), student2.getName());
        assertNotEquals(student1, student2);
        assertEquals(student3, student4);

        assertNotNull(student1);
        assertNotNull(student2);
        assertNotNull(student3);
        assertNotNull(student4);
        System.out.println("Equality test passed successfully");
    }

    @Test
    void c_objectIdentity(){
        assertNotSame(student1.getStudentId(),student2.getStudentId());
        assertNotSame(student1.getEmail(),student2.getEmail());
        assertNotSame(student1.getName(),student2.getName());
        assertSame(student3,student4);

        assertNotNull(student1);
        assertNotNull(student2);
        assertNotNull(student3);
        assertNotNull(student4);
        System.out.println("Identity successfully passed");


    }

}