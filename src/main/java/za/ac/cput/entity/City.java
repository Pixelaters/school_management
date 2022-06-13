/* City.java
Entity for the City
Author: Ongezwa Gwaza (211272183)
Date: 11 June 2022
*/
package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class City {
    // Entity variables

    @Id
    private String id;
    private String name;

    @OneToMany
    @JoinColumn(name = "CountryName",nullable = false)
    private Country country; //false error

    // Default constructor
    public City() {
    }

    // Constructor with builder
    public City(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.country = builder.country;

    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }


    //fix this code, look at Breytons Employee code as example
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        City city = (City) obj;
        if (country == null) {
            if (city.country != null)
                return false;
        } else if (!country.equals(city.country))
            return false;
        if (id == null) {
            if (city.id != null)
                return false;
        } else if (!id.equals(city.id))
            return false;
        if (name == null) {
            if (city.name != null)
                return false;
        } else if (!name.equals(city.name))
            return false;
        return true;
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
            this.country = city.country;

            return this;
        }

        // build method
        public City build() {
            return new City(this);
        }

    }

}
