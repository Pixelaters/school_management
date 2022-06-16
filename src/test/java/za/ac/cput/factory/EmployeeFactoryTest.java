package za.ac.cput.factory;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Employee;
import za.ac.cput.entity.Name;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmployeeFactoryTest {

    ArrayList<Employee> employee = new ArrayList<Employee>();
    private static final Employee employee1 = EmployeeFactory.builder("101A","dix@gmail.com",
            NameFactory.buildName("James","John","Doe"));
    private static final Employee employee2 = EmployeeFactory.builder("123B","jinx@gmail.com",
            NameFactory.buildName("Dixon","","Sean"));
    private static final Employee employee3 = EmployeeFactory.builder("131C","217203027@mycput.ac.za",
            NameFactory.buildName("Breyton","Sean","Ernstzen"));
    private static final Employee employee4 = employee3;

    @Test
    void a_builder() {
        employee.add(employee1);
        System.out.println("Added: " + employee.get(0));
        employee.add(employee2);
        System.out.println("Added: " + employee.get(1));
        employee.add(employee3);
        System.out.println("Added: " + employee.get(2));

        assertAll(
                () -> assertNotNull(employee1),
                () -> assertNotNull(employee2),
                () -> assertNotNull(employee3),
                () -> assertNotNull(employee2.getName()),
                () -> assertNotNull(employee3.getName()),
                () -> assertNotNull(employee4.getName())
        );

    }

    @Test
    void b_objectEquality(){


        assertAll(
                () -> assertNotEquals(employee1.getStaffId(),employee2.getStaffId()),
                () -> assertNotEquals(employee1.getEmail(),employee2.getEmail()),
                () -> assertNotEquals(employee1,employee2),
                () -> assertEquals(employee3,employee4),
                () -> assertNotNull(employee1),
                () -> assertNotNull(employee2),
                () -> assertNotNull(employee3),
                () -> assertNotNull(employee4)
        );

        System.out.println("Equality test passed successfully");
    }

    @Test
    void c_objectIdentity(){

        assertAll(
                () ->  assertNotSame(employee1.getStaffId(),employee2.getStaffId()),
                () ->  assertNotSame(employee1.getEmail(),employee2.getEmail()),
                () ->  assertSame(employee3,employee4),
                () ->  assertNotNull(employee1),
                () ->  assertNotNull(employee2),
                () ->  assertNotNull(employee3),
                () ->  assertNotNull(employee4)

        );


        System.out.println("Identity test pass successfully");
    }
}