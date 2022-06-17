package za.ac.cput.factory;

/* Ethan George
Student Number :218008430


 */

import za.ac.cput.entity.Country;
import za.ac.cput.helper.StringHelper;


public class CountryFactory {
    public static Country createCountry(String countryName, String countryId) {

        if (StringHelper.isEmptyOrNull(countryId) || StringHelper.isEmptyOrNull(countryId)) {
            throw new IllegalArgumentException(" ");

        }


        return new Country.Builder()
                .setId(countryId)
                .Name(countryName)
                .build();

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

