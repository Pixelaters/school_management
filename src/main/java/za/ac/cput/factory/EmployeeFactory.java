package za.ac.cput.factory;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;
import za.ac.cput.helper.StringHelper;

import java.util.regex.Pattern;

public class EmployeeFactory {
    private static final String validation = "^(.+)@(.+)$";

    public static Employee builder(String staffId, String email,Name name){
        //checks first if the conditions is met.
        //if no staff id is entered or invalid email is entered, it should throw an IllegalArgumentException
        StringHelper.checkStringParam("staffId",staffId);
        if(!Pattern.matches(validation,email))
            throw new IllegalArgumentException("Some details missing or invalid email(add '@' into your email)");
        return new Employee.Builder()
                .staffId(staffId)
                .email(email)
                .name(name)
                .build();

        }
    }

