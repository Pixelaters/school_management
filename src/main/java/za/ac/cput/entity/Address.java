package za.ac.cput.entity;

import javax.persistence.Entity;
import java.util.Objects;

//@Entity
public class Address {
    private final String unitNumber;
    private final String complexName;
    private final String streetNumber;
    private final int postalCode;
    //private final City city;


    public Address(Builder builder) {
        this.unitNumber = builder.unitNumber;
        this.complexName = builder.complexName;
        this.streetNumber = builder.streetNumber;
        this.postalCode = builder.postalCode;
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


    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }

    public static class Builder {
        private String unitNumber;
        private String complexName;
        private String streetNumber;
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

        public Builder PostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy(Address address){
            this.unitNumber = address.unitNumber;
            this.complexName = address.complexName;
            this.streetNumber = address.streetNumber;
            this.postalCode = address.postalCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

        @Override
        public boolean equals(Object o){
            if (this==o) return true;
            if (o==null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return true;
            //return primarykey.equals(Address.primarykey);
        }

        //@Override
        //public int hashCode(return Objects.hash(primarykey))

    }
}
