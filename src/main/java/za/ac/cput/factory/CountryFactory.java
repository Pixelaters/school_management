package za.ac.cput.factory;

/* Ethan George
Student Number :218008430 ,Ziyaad Petersen(219083479), Raeece Samuels (217283764), Breyton Ernstzen (217203027)


 */

import za.ac.cput.domain.Country;
import za.ac.cput.helper.StringHelper;


public class CountryFactory {
//    public static Country createCountry(String countryName, String countryId) {
//
//        if (StringHelper.isEmptyOrNull(countryName) || StringHelper.isEmptyOrNull(countryId)) {
//            throw new IllegalArgumentException("Country id is empty or null");
//
//        }
//        return new Country.Builder()
//                .id(countryId)
//                .name(countryName)
//                .build();
//
//    }

//    public static Country builder(String s, String south_africa) {
//
//    }
//    public static Country builder(String s, String south_africa) {
//    }


    public static Country builder(String countryId, String countryName) {

        StringHelper.checkStringParam("1" , countryId);
        StringHelper.checkStringParam("2" , countryName);
        return new Country.Builder().id(countryId).name(countryName).build();
    }
}

