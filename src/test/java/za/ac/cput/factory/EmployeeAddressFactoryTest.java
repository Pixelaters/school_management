package za.ac.cput.factory;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
import org.apache.tomcat.jni.Address;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Employee;
import za.ac.cput.entity.EmployeeAddress;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmployeeAddressFactoryTest {
    //private static final Address address = new Address("");
    ArrayList<EmployeeAddress> employeeAddresses = new ArrayList<EmployeeAddress>();
    private static final EmployeeAddress ea1 = EmployeeAddressFactory.builder("101A",
            AddressFactory.build("K18","Forest Hill","6",7100,
                    "Searle Street", CityFactory.buildCity("333","Cape Town",
                            CountryFactory.createCountry("South Africa","RSA-CT"))));
    private static final EmployeeAddress ea2 = EmployeeAddressFactory.builder("123B",
            AddressFactory.build("E145","Bayview", "52",7306,
                    "Bird Avenue", CityFactory.buildCity("AA1","Kimberley",
                            CountryFactory.createCountry("South Africa","RSA-K"))));
    private static final EmployeeAddress ea3 = EmployeeAddressFactory.builder("131C",
            AddressFactory.build("B20A","De-Zalze","12",7309,
                    "Jan van Riebeeck Ave", CityFactory.buildCity("BF101","Bloemfontein",
                            CountryFactory.createCountry("South Africa","RSA-B"))));
    private static final EmployeeAddress ea4 = ea3;

    @Test
    void builder() {
        employeeAddresses.add(ea1);
        System.out.println("Added: " + employeeAddresses.get(0));
        employeeAddresses.add(ea2);
        System.out.println("Added: " + employeeAddresses.get(1));
        employeeAddresses.add(ea3);
        System.out.println("Added: " + employeeAddresses.get(2));
        employeeAddresses.add(ea4);
        System.out.println("Added: " + employeeAddresses.get(3));

        //checks if all staffId's are not null/empty
        assertAll(
                () -> assertNotNull(ea1),
                () -> assertNotNull(ea2),
                () -> assertNotNull(ea3),
                () -> assertNotNull(ea4)
        );

        for (EmployeeAddress employeeAddress : employeeAddresses) {
            assertNotNull(employeeAddress.getStaffId());
        }
        System.out.println("Employee addresses added...");

    }

    @Test
    void objectEquality(){

        assertAll(
                () -> assertNotEquals(ea1,ea2),
                () -> assertNotEquals(ea1,ea3),
                () -> assertNotEquals(ea1,ea4),
                () -> assertNotEquals(ea1.getStaffId(),ea2.getStaffId()),
                () -> assertNotEquals(ea1.getStaffId(),ea3.getStaffId()),
                () -> assertNotEquals(ea1.getStaffId(),ea4.getStaffId()),
                () -> assertEquals(ea3,ea4)
        );

        System.out.println("Equality test passed successfully");
    }

    @Test
    void objectIdentity(){

        assertAll(
                () -> assertNotSame(ea1,ea2),
                () -> assertNotSame(ea1,ea3),
                () -> assertNotSame(ea1,ea4),
                () -> assertNotSame(ea1.getStaffId(),ea2.getStaffId()),
                () -> assertNotSame(ea1.getStaffId(),ea3.getStaffId()),
                () -> assertNotSame(ea1.getStaffId(),ea4.getStaffId()),
                () -> assertSame(ea3,ea4)
        );
        System.out.println("Identity test passed successfully");

    }
}