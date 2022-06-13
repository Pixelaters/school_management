/* CityFactory.java
Factory class for the City
Author: Ongezwa Gwaza (211272183)
Date: 13 June 2022
*/
package za.ac.cput.factory;

import java.util.Objects;

import za.ac.cput.entity.City;
import za.ac.cput.entity.Country;

public class CityFactory {

    //use StringHelper
    public static City buildCity(String id, String name, Country country) {
        // valid object properties
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("The id can not be null or empty");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The name can not be null or empty");
        }
        if (Objects.isNull(country)) {
            throw new IllegalArgumentException("The country can not be null");
        }

        // if properties are valid create city instance
        return new City.Builder()
                .id(id)
                .name(name)
                .country(country)
                .build();

    }

}
