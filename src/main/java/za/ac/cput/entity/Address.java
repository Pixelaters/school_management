package za.ac.cput.entity;

/*Ziyaad Petersen
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import za.ac.cput.entity.City;

@Embeddable
public class Address {
    private String unitNumber;
    private String complexName;
    private String streetNumber;
    private String streetName;
    private int postalCode;

    @Embedded
    private City city;

    protected Address() {
    }

    public Address(Builder builder) {
        this.unitNumber = builder.unitNumber;
        this.complexName = builder.complexName;
        this.streetNumber = builder.streetNumber;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
        this.streetName= builder.streetName;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getStreetName() {
        return streetName;
    }


    public City getCity() {
        return city;
    }


    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }

//    @Override
//    public int hashCode{
//        return Objects.hash()
//    }

    public static class Builder {
        private String unitNumber;
        private String complexName;
        private String streetNumber;
        private String streetName;
        private City city;
        private int postalCode;

        public Builder UnitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder ComplexName(String complexName) {
            this.complexName = complexName;
            return this;
        }

        public Builder StreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder StreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder PostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder City(City city){
            this.city = city;
            return this;
        }

        public Builder copy(Address address){
            this.unitNumber = address.unitNumber;
            this.complexName = address.complexName;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.postalCode = address.postalCode;
            this.city= address.city;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

//        @Override
//        public boolean equals(Object o){
//            if (this==o) return true;
//            if (o==null || getClass() != o.getClass()) return false;
//            Address address = (Address) o;
//            return true;
//            //return primarykey.equals(Address.primarykey);
//        }

        //@Override
        //public int hashCode(return Objects.hash(primarykey))

    }
}
