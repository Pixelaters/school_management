package za.ac.cput.factory;
/* Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import java.util.regex.*;
import za.ac.cput.entity.Name;
import za.ac.cput.entity.Student;
import za.ac.cput.helper.StringHelper;
public class  StudentFactory {
    private static final String validation = "^(.+)@(.+)$";


    public static Student build(String studentId, String email){
        StringHelper.checkStringParam("217283764",studentId);
        if (!Pattern.matches(validation,email))
            throw new IllegalArgumentException("Some requirements are missing or details are not entered correctly");
        return new Student.Builder().studentId(studentId).email(email).build();

    }
}
