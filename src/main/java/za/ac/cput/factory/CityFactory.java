/* CityFactory.java
Factory class for the City
Author: Ongezwa Gwaza (211272183)
Date: 13 June 2022
*/
package za.ac.cput.factory;


import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.helper.StringHelper;

public class CityFactory {

    //use StringHelper
    public static City buildCity(String id, String name, Country country) {
        // valid object properties
        StringHelper.checkStringParam("id",id);
        StringHelper.checkStringParam("name",name);


        // if properties are valid create city instance
        return new City.Builder()
                .id(id)
                .name(name)
                .country(country)
                .build();

    }

}
