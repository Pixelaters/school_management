/* CityFactory.java
Factory class for the City
Author: Ongezwa Gwaza (211272183)
Date: 13 June 2022
*/
package za.ac.cput.factory;

import java.util.Objects;

import za.ac.cput.entity.City;
import za.ac.cput.entity.Country;
import za.ac.cput.helper.StringHelper;

public class CityFactory {

    //use StringHelper
    public static City buildCity(String id, String name, Country country) {
        // valid object properties
        StringHelper.checkStringParam("id",id);
        StringHelper.checkStringParam("name",name);
        //Country must be instantiated in the Country class and Objects.isNull is not preferably used here.
//        if (Objects.isNull(country)) {
//            throw new IllegalArgumentException("The country can not be null");
//        }

        // if properties are valid create city instance
        return new City.Builder()
                .id(id)
                .name(name)
                .country(country)
                .build();

    }

}
