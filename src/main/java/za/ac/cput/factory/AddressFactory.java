package za.ac.cput.factory;

/*Ziyaad Petersen
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */

import za.ac.cput.entity.Address;
import za.ac.cput.entity.City;
import za.ac.cput.helper.StringHelper;

public class AddressFactory {
    public static Address build(String unitNumber, String complexName, String streetNumber, int postalCode, City city ){
        StringHelper.checkStringParam("unitNumber",unitNumber);
        StringHelper.checkStringParam("complexName",complexName);
        StringHelper.checkStringParam("streetNumber",streetNumber);
        //StringHelper.checkStringParam("postalCode",postalCode); //make a helper class that accepts 4 digits?
        //StringHelper.checkStringParam("City",city); //make helper class that makes string not null?
        return new Address.Builder().UnitNumber(unitNumber).ComplexName(complexName).StreetNumber(streetNumber).PostalCode(postalCode).build(); //City(city)??
    }
}
