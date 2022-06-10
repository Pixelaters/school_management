package za.ac.cput.factory;

import za.ac.cput.entity.Address;
import za.ac.cput.entity.EmployeeAddress;

/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
public class EmployeeAddressFactory {

    public static EmployeeAddress builder(String staffId, Address getAddress){
        if(staffId.isEmpty())
            throw new IllegalArgumentException("Staff id cannot be empty");
        return new EmployeeAddress.Builder()
                .staffId(staffId)
                .address(getAddress)
                .build();

    }
}
