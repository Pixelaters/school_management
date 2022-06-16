package za.ac.cput.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeAPITest {

    @Autowired private EmployeeService employeeService;

    @Autowired private EmployeeAPI employeeAPI;

    private Employee employee = EmployeeFactory.builder("101","b@gmail.com",
            NameFactory.buildName("Ziyaad","","Bawa"));
    private Employee employee1 = EmployeeFactory.builder("101","b1@gmail.com",
            NameFactory.buildName("Ziyaad","","petersen"));

    @Test
    void create() {
        employee = this.employeeAPI.create(this.employee);
        employee1 = this.employeeAPI.create(this.employee1);
    }

    @Test
    void read() {
    }
}