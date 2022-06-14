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
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.repository.EmployeeIRepository;
import za.ac.cput.service.impl.EmployeeIService;

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
                .name(null)
                .build();

        employee2 = new Employee.Builder()
                .staffId("101")
                .email("sean@gmail.com")
                .name(null)
                .build();
    }

    @Test
    void a_create() {
        employeeIRepository.save(employee1);
        employeeIRepository.save(employee2);

        assertAll(
                () -> assertNotNull(employee1.getStaffId()),
                () -> assertNotNull(employee2.getStaffId()),
                () -> assertNotNull(employee1.getEmail()),
                () -> assertNotNull(employee2.getEmail()),
                () -> assertNull(employee1.getName()),
                () -> assertNull(employee2.getName())
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

        System.out.println(employee1.toString());
        System.out.println(employee2.toString());

    }

    @Test
    void c_delete() {
        employeeIRepository.deleteById(employee1.getStaffId());
        employeeIRepository.deleteById(employee2.getStaffId());

        assertAll(
                () -> assertNotNull(employee1.getStaffId()),
                () -> assertNotNull(employee2.getStaffId()),
                () -> assertNotSame(employee1.getStaffId(),employee2.getStaffId()),
                () -> assertNotEquals(employee1.getStaffId(),employee2.getStaffId())
        );

        System.out.println("Deletion success...");
    }

    @Test
    void d_getAll() {
        System.out.println(employeeIRepository.findAll());
    }
}