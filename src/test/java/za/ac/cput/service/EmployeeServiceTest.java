package za.ac.cput.service;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Employee;
import za.ac.cput.entity.Name;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.repository.EmployeeIRepository;
import za.ac.cput.service.impl.EmployeeIService;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmployeeServiceTest {
    @Mock
    private EmployeeIRepository employeeIRepository;

    EmployeeService employeeService;
    private static Employee employee1,employee2;

    @BeforeEach
    void setUp(){
        employeeService = new EmployeeService(employeeIRepository);
        employee1 = new Employee.Builder()
                .staffId("121")
                .email("brey@gmail.com")
                .name(NameFactory.buildName("Brey","Gift","Christen"))
                .build();


        employee2 = new Employee.Builder()
                .staffId("101")
                .email("jt@gmail.com")
                .name(NameFactory.buildName("Jeremih","","Tyler"))
                .build();
    }

    @Test
    void a_create() {
        employeeIRepository.save(employee1);
        employeeIRepository.save(employee2);

        assertAll(
                () -> assertNotNull(employee1),
                () -> assertNotNull(employee2),
                () -> assertNotNull(employee1.getStaffId()),
                () -> assertNotNull(employee2.getStaffId()),
                () -> assertNotNull(employee1.getEmail()),
                () -> assertNotNull(employee2.getEmail()),
                () -> assertNotNull(employee1.getName()),
                () -> assertNotNull(employee2.getName())
        );

        System.out.println("Employees added...");
    }

    @Test
    void b_read() {
        employeeIRepository.getReferenceById(employee1.getStaffId());
        employeeIRepository.getReferenceById(employee2.getStaffId());

        assertAll(
                () -> assertNotNull(employee1.getStaffId()),
                () -> assertNotNull(employee2.getStaffId()),
                () -> assertNotSame(employee1.getStaffId(),employee2.getStaffId()),
                () -> assertNotEquals(employee1.getStaffId(),employee2.getStaffId())
        );
        System.out.println();
        System.out.println("Reading...");
        System.out.println(employee1.toString());
        System.out.println(employee2.toString());
        System.out.println();
    }

    @Test
    void c_readByNameAndEmail() {
        employeeIRepository.getReferenceById(employee1.getStaffId());
        employeeIRepository.getReferenceById(employee2.getStaffId());

        assertAll(
                () -> assertNotNull(employee1.getStaffId()),
                () -> assertNotSame(employee1.getStaffId(), employee2.getStaffId()),
                () -> assertNotEquals(employee1.getStaffId(), employee2.getStaffId())
        );

    }

    @Test
    void d_delete() {
        employeeIRepository.deleteById(employee1.getStaffId());
        employeeIRepository.deleteById(employee2.getStaffId());

        assertAll(
                () -> assertNotNull(employee1.getStaffId()),
                () -> assertNotNull(employee2.getStaffId()),
                () -> assertNotSame(employee1.getStaffId(),employee2.getStaffId()),
                () -> assertNotEquals(employee1.getStaffId(),employee2.getStaffId())
        );
        System.out.println();
        System.out.println("Deletion success...");
    }

    @Test
    void e_getAll() {
        System.out.println();
        System.out.println(employeeIRepository.findAll());

    }
}