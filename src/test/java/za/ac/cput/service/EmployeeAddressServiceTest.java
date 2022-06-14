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
import za.ac.cput.entity.EmployeeAddress;
import za.ac.cput.repository.EmployeeAddressIRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmployeeAddressServiceTest {
    @Mock
    private EmployeeAddressIRepository employeeAddressIRepository;
    EmployeeAddressService employeeAddressService;

    private static EmployeeAddress employeeAddress1,employeeAddress2;


    @BeforeEach
    void setUp() {
        employeeAddressService = new EmployeeAddressService(employeeAddressIRepository);

        employeeAddress1 = new EmployeeAddress.Builder()
                .staffId("121")
                .address(null)
                .build();

        employeeAddress2 = new EmployeeAddress.Builder()
                .staffId("101")
                .address(null)
                .build();
    }

    @Test
    void a_create() {
        employeeAddressIRepository.save(employeeAddress1);
        employeeAddressIRepository.save(employeeAddress2);

        assertAll(
                () -> assertNotNull(employeeAddress1.getStaffId()),
                () -> assertNotNull(employeeAddress2.getStaffId()),
                () -> assertNull(employeeAddress1.getAddress()),
                () -> assertNull(employeeAddress2.getAddress())
        );

        System.out.println("Employees added...");
    }

    @Test
    void b_read() {
        employeeAddressIRepository.getReferenceById(employeeAddress1.getStaffId());
        employeeAddressIRepository.getReferenceById(employeeAddress2.getStaffId());

        assertAll(
                () -> assertNotNull(employeeAddress1.getStaffId()),
                () -> assertNotNull(employeeAddress2.getStaffId()),
                () -> assertNotSame(employeeAddress1.getStaffId(),employeeAddress2.getStaffId()),
                () -> assertNotEquals(employeeAddress1.getStaffId(),employeeAddress2.getStaffId())
        );
        System.out.println(employeeAddress1.toString());
        System.out.println(employeeAddress2.toString());
    }

    @Test
    void c_delete() {
        employeeAddressIRepository.deleteById(employeeAddress1.getStaffId());
        employeeAddressIRepository.deleteById(employeeAddress2.getStaffId());

        assertAll(
                () -> assertNotNull(employeeAddress1.getStaffId()),
                () -> assertNotNull(employeeAddress2.getStaffId()),
                () -> assertNotSame(employeeAddress1.getStaffId(),employeeAddress2.getStaffId()),
                () -> assertNotEquals(employeeAddress1.getStaffId(),employeeAddress2.getStaffId())
        );

        System.out.println("Deletion success...");
    }

    @Test
    void d_getAll() {
        System.out.println(employeeAddressIRepository.findAll());
    }
}