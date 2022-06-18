package za.ac.cput.api;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 16 June 2022
  School Management
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.NameFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmployeeAPITest {

    @Autowired private EmployeeAPI employeeAPI;

    private Employee employee;
    private Employee employee1;

    @BeforeEach
    void setUp() {
        employee = EmployeeFactory.builder("101","b@gmail.com",
                NameFactory.buildName("Ziyaad","","Bawa"));
        employee1 = EmployeeFactory.builder("102","b1@gmail.com",
                NameFactory.buildName("Ziyaad","John","petersen"));
    }

    @Test
    void a_create() {
            employee = this.employeeAPI.create(this.employee);
            employee1 = this.employeeAPI.create(this.employee1);

            assertAll(
                    () ->  assertNotNull(employee),
                    () ->  assertNotNull(employee1),
                    () ->  assertNotSame(employee,employee1),
                    () ->  assertSame("Ziyaad",employee1.getName().getFirstName())
            );
    }

    @Test
    void b_read(){
        employee = this.employeeAPI.read(this.employee);

        assertAll(
                () -> assertNotNull(employee),
                () -> assertNotSame(employee,employee1)
        );

        System.out.println("Read success...");
    }

    @Test
    void c_delete(){
        employee1 = this.employeeAPI.delete(this.employee1);

        assertAll(
                () -> assertNotNull(employee1),
                () -> assertSame("Ziyaad",employee1.getName().getFirstName()),
                () -> assertSame("102",employee1.getStaffId()),
                () -> assertSame("b1@gmail.com",employee1.getEmail()),
                () -> assertSame("petersen",employee1.getName().getLastName()),
                () -> assertSame("John",employee1.getName().getMiddleName())
        );

        System.out.println("Deletion success...");
    }
}