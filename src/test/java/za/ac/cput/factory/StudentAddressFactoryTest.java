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
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class StudentAddressFactoryTest {

    ArrayList<StudentAddress> studentAddress = new ArrayList<>();
    private static final StudentAddress studentAddress1 = StudentAddressFactory.build("25015435",
            AddressFactory.build("","mavericks","258","Kit Kat",1111,
                    CityFactory.buildCity("120","Cape Town/CT",
                            CountryFactory.builder("CT/RSA","RSA/CT"))));
    private static final StudentAddress studentAddress2 = StudentAddressFactory.build("28965234",
            AddressFactory.build("7","Austin","79","Mavericks",1111,
                    CityFactory.buildCity("121","Johannesburg/JHB",
                            CountryFactory.builder("JHB/RSA","RSA/JHB"))));
    private static final StudentAddress studentAddress3 = StudentAddressFactory.build("23152687",
            AddressFactory.build("2597","American Bash","85","Chomps",1111,
                    CityFactory.buildCity("123","KwaZulu-Natal/KZN",
                            CountryFactory.builder("KZN/RSA","RSA/KZN"))));
    private static final StudentAddress studentAddress4 = studentAddress3;

    @Test
    void a_builder(){
        studentAddress.add(studentAddress1);
        System.out.println("Added: " + studentAddress.get(0));
        studentAddress.add(studentAddress2);
        System.out.println("Added: " + studentAddress.get(1));
        assertNotNull(studentAddress);
        studentAddress.add(studentAddress3);
        System.out.println("Added: " + studentAddress.get(2));
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
