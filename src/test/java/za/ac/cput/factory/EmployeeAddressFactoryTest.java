package za.ac.cput.factory;

import org.apache.tomcat.jni.Address;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Employee;
import za.ac.cput.entity.EmployeeAddress;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmployeeAddressFactoryTest {
    //private static final Address address = new Address("");
    ArrayList<EmployeeAddress> employeeAddresses = new ArrayList<EmployeeAddress>();
    private static final EmployeeAddress ea1 = EmployeeAddressFactory.builder("101A");
    private static final EmployeeAddress ea2 = EmployeeAddressFactory.builder("123B");
    private static final EmployeeAddress ea3 = EmployeeAddressFactory.builder("131C");
    private static final EmployeeAddress ea4 = ea3;

    @Test
    void builder() {
        employeeAddresses.add(ea1);
        System.out.println("Added: " + employeeAddresses.get(0));
        //employeeAddresses.add(ea2);
        //System.out.println("Added: " + employeeAddresses.get(1));
        //employeeAddresses.add(ea3);
        //System.out.println("Added: " + employeeAddresses.get(2));
        //employeeAddresses.add(ea4);
        //System.out.println("Added: " + employeeAddresses.get(3));

        //checks if all staffId's are not null/empty
        for (EmployeeAddress employeeAddress : employeeAddresses) {
            assertNotNull(employeeAddress.getStaffId());
        }

    }

    @Test
    void objectEquality(){
        assertNotEquals(ea1.getStaffId(),ea2.getStaffId());
        assertNotEquals(ea1.getStaffId(),ea3.getStaffId());
        assertNotEquals(ea1.getStaffId(),ea4.getStaffId());

        assertEquals(ea3,ea4);

        System.out.println("Equality test passed successfully");
    }

    @Test
    void objectIdentity(){
        assertNotSame(ea1.getStaffId(),ea2.getStaffId());
        assertNotSame(ea1.getStaffId(),ea3.getStaffId());
        assertNotSame(ea1.getStaffId(),ea4.getStaffId());

        assertSame(ea3,ea4);

        System.out.println("Identity test passed successfully");

    }
}