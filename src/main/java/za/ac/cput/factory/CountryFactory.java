package za.ac.cput.factory;

/* Ethan George
Student Number :218008430


 */

import za.ac.cput.entity.Country;

public class CountryFactory {

   private static final String validation = "^(.+)@(.+)$";

    public static Country builder(String countryId , String countryName){

        if (countryId.isEmpty() || !countryName.matches(validation))
            throw new IllegalArgumentException("Country Name is missing");
        return new Country.Builder()
                .countryId(countryId)
                .countryName(countryName)
                .build();
    }
}
