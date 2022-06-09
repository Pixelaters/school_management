package za.ac.cput.factory;

import za.ac.cput.entity.Employee;
import za.ac.cput.entity.Name;

/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
public class EmployeeFactory {
    public static Employee builder(String staffId, String email,Name name){
        if(staffId.isEmpty() || email.isEmpty())
            throw new IllegalArgumentException("Some details missing");
        return new Employee.Builder()
                .staffId(staffId)
                .email(email)
                .name(name)
                .build();
        }
    }

