/* City.java
Entity for the City
Author: Ongezwa Gwaza (211272183)
Date: 11 June 2022
*/
package za.ac.cput.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

@Entity
//@Embeddable
public class City implements Serializable {// used serializable to write files to the Database
    // Entity variables

    @Id
    private String id;
    private String name;

    //@Embedded
    @OneToMany(targetEntity = Country.class, mappedBy = "id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)//This retrieves the Country records
    private Set<Country> country; //false error

    // Default constructor
    public City() {
    }

    // Constructor with builder
    public City(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.country = Collections.singleton(builder.country);

    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return (Country) country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        City city = (City) o;
        return id.equals(city.id);
    }

    @Override
    public String toString() {
        return "City [country=" + country + ", id=" + id + ", name=" + name + "]";
    }

    // Builder class
    public static class Builder {
        private String id;
        private String name;
        private Country country;

        // id builder method
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        // name builder method
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        // country builder method
        public Builder country(Country country) {
            this.country = country;
            return this;
        }

        // method for copying city object
        public Builder copy(City city) {
            this.id = city.id;
            this.name = city.name;
            this.country = (Country) city.country;

            return this;
        }

        // build method
        public City build() {
            return new City(this);
        }

    }

}
