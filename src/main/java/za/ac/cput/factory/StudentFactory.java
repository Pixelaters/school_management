package za.ac.cput.factory;
/* Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
import za.ac.cput.entity.Name;
import za.ac.cput.entity.Student;
import za.ac.cput.helper.StringHelper;
public class  StudentFactory {
    public static Student build(String studentId, String email, Name name){
        StringHelper.checkStringParam("217283764",studentId);
        StringHelper.checkStringParam("Giannis@365.com",email);
        return new Student.Builder().studentId(studentId).email(email).name(name).build();

    }
}
