package za.ac.cput.api;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.factory.EmployeeAddressFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmployeeAddressAPITest {

    private Address address;

    @Autowired
    private EmployeeAddressAPI employeeAddressAPI;

    private EmployeeAddress employeeAddress1,employeeAddress2;

    @BeforeEach
    void setUp() {
        employeeAddress1 = EmployeeAddressFactory.builder("101",
                AddressFactory.build("K18","Burgandy Estate","6",
                        "Bird Avenue",7100, CityFactory.buildCity("CT001", "Cape Town",
                                CountryFactory.builder("RSA-CT001","South Africa"))));

        employeeAddress2 = EmployeeAddressFactory.builder("102",
                AddressFactory.build("K20","Weltevreden","52",
                        "Voortrekker Road",7300, CityFactory.buildCity("MB002", "Malmesbury",
                                CountryFactory.builder("RSA-MB002","South Africa"))));
    }

    @Test
    void a_create() {
        employeeAddress1 = this.employeeAddressAPI.create(this.employeeAddress1);
        employeeAddress2 = this.employeeAddressAPI.create(this.employeeAddress2);

        assertAll(
                () ->  assertNotNull(employeeAddress1),
                () ->  assertNotNull(employeeAddress2),
                () ->  assertNotSame(employeeAddress1,employeeAddress2),
                () ->  assertNotSame(employeeAddress1.getStaffId(),employeeAddress2.getStaffId()),
                () ->  assertNotEquals(employeeAddress1.getStaffId(),employeeAddress2.getStaffId()),
                () ->  assertNotEquals(employeeAddress1,employeeAddress2)
        );
    }

    @Test
    void b_read() {
        employeeAddress1 = this.employeeAddressAPI.read(this.employeeAddress1);

        assertAll(
                () -> assertNotNull(employeeAddress1),
                () -> assertNotSame(employeeAddress1,employeeAddress2)
        );

        System.out.println("Read success...");
    }

    @Test
    void delete() {
        employeeAddress2 = this.employeeAddressAPI.delete(this.employeeAddress2);

        assertAll(
                () -> assertNotNull(employeeAddress2),
                () -> assertSame("102",employeeAddress2.getStaffId()),
                () -> assertSame("K20",employeeAddress2.getAddress().getUnitNumber()),
                () -> assertSame("MB002",employeeAddress2.getAddress().getCity().getId())
        );

        System.out.println("Deletion success...");
    }
}