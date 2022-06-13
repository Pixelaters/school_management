package za.ac.cput.factory;

/* Ethan George
Student Number :218008430


 */

import za.ac.cput.entity.Country;
import za.ac.cput.helper.StringHelper;


//why you using email validation to check if country name?
//pls use stringhelper
public class CountryFactory {
    public static Country builder(String s, String wales) {

        //error
        return builder(Country);
    }
//    public static Country builder(String s, String south_africa) {
//
//    }
//    public static Country builder(String s, String south_africa) {
//    }


//    public static Country builder(String countryId, String countryName) {
//
//        StringHelper.checkStringParam("1" , countryId);
//        StringHelper.checkStringParam("2" , countryName);
//        return new Country.Builder().setCountryId().setCountryName(countryName);
//    }
}

