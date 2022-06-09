package za.ac.cput.factory;

import za.ac.cput.entity.Address;
import za.ac.cput.entity.EmployeeAddress;

/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
public class EmployeeAddressFactory {

    public static EmployeeAddress builder(String staffId, Address address){
        if(staffId.isEmpty())
            throw new IllegalArgumentException("No staff id found");
        return new EmployeeAddress.Builder()
                .staffId(staffId)
                .address(address)
                .build();

    }
}
