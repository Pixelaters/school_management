package za.ac.cput.factory;

/*Ziyaad Petersen
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
import java.util.regex.*;
import za.ac.cput.entity.Address;
import za.ac.cput.entity.City;
import za.ac.cput.helper.StringHelper;

public class AddressFactory {
    public static Address build(String unitNumber, String complexName, String streetNumber, int postalCode, String streetName, City city ){
        StringHelper.setEmptyIfNull(unitNumber);
        StringHelper.setEmptyIfNull(complexName);
        StringHelper.checkStringParam("streetNumber",streetNumber);
        StringHelper.checkStringParam("streetName",streetName);
        if (postalCode<999 || postalCode> 9999){
            throw new IllegalArgumentException("Postal code needs to be 4 digits");
        }
        //StringHelper.checkStringParam("postalCode",postalCode); //make a helper class that accepts 4 digits
        return new Address.Builder().UnitNumber(unitNumber).ComplexName(complexName).StreetNumber(streetNumber).PostalCode(postalCode).build(); //City(city)??
    }
}
