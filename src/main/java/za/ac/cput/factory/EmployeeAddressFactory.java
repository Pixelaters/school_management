package za.ac.cput.factory;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
import za.ac.cput.entity.Address;
import za.ac.cput.entity.EmployeeAddress;
import za.ac.cput.helper.StringHelper;

public class EmployeeAddressFactory {

    public static EmployeeAddress builder(String staffId,Address address){

        StringHelper.checkStringParam("staffId",staffId);
        return new EmployeeAddress.Builder()
                .staffId(staffId)
                .address(address)
                .build();

    }
}
