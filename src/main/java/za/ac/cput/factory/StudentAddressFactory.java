package za.ac.cput.factory;
/* Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */

import za.ac.cput.entity.StudentAddress;
import za.ac.cput.helper.StringHelper;
import za.ac.cput.entity.Address;
public class StudentAddressFactory {
    public static StudentAddress build(String studentId,Address address){
        StringHelper.checkStringParam("3896578924",studentId);
        return new StudentAddress.Builder().studentId(studentId).address(address).build();

    }
}
