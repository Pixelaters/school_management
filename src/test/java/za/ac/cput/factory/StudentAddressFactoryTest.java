package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.StudentAddress;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/* Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 11 June 2022
  School Management
 */
@TestMethodOrder(MethodOrderer.class)
class StudentAddressFactoryTest {

    ArrayList<StudentAddress> studentAddress = new ArrayList<>();
    private static final StudentAddress studentAddress1 = StudentAddressFactory.build("2501842");
    private static final StudentAddress studentAddress2 = StudentAddressFactory.build("2896547");
    private static final StudentAddress studentAddress3 = StudentAddressFactory.build("2963572");
    private static final StudentAddress studentAddress4 = studentAddress3;

    @Test
    void a_builder(){
        studentAddress.add(studentAddress2);
        System.out.println("Added: " + studentAddress.get(0));
        studentAddress.add(studentAddress2);
        System.out.println("Added: " + studentAddress.get(1));
        assertNotNull(studentAddress);
        System.out.println("Builder test passed");
    }

    @Test
    void b_ObjectEquality(){
        assertNotEquals(studentAddress1.getStudentId(),studentAddress2.getStudentId());
        //assertNotEquals(studentAddress1.getAddress(),studentAddress2.getAddress());
        assertNotEquals(studentAddress1, studentAddress2);
        assertEquals(studentAddress3, studentAddress4);

        assertNotNull(studentAddress1);
        assertNotNull(studentAddress2);
        assertNotNull(studentAddress3);
        assertNotNull(studentAddress4);
        System.out.println("Equality test passed successfully");
    }

    @Test
    void c_objectIdentity(){
        assertNotSame(studentAddress1.getStudentId(), studentAddress2.getStudentId());
        //assertNotSame(studentAddress1.getAddress(),studentAddress2.getAddress());
        assertSame(studentAddress3,studentAddress4);

        assertNotNull(studentAddress1);
        assertNotNull(studentAddress2);
        assertNotNull(studentAddress3);
        assertNotNull(studentAddress4);
        System.out.println("Identity successfully passed");
    }
}
