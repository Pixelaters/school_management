package za.ac.cput.entity;

//Ethan George
//Student Number :218008430

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Embeddable
public class Country {


    @Id
    private String countryId;

    @NotNull
    private String countryName;



    protected Country(String countryId, String countryName) {

    }

    private Country(Builder b){
        this.countryId = b.countryId;
        this.countryName = b.countryName;
    }

    public Country() {

    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }



    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                " Country id='" + countryId + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }

//    public boolean equals(Objects o){
//        if(this == o) return true;
//        if (o == null || getClass() !=o.getClass()) return false;
//        Country country = (Country) o;
//        return countryId.equals(country.countryId);
//    }


//    @Override
//    public int hasCode(){
//        return Objects.hash(countryId);
//    }


    public static class Builder{
        private String countryId;
        private String countryName;

        public Builder setCountryId(String countryId){
            this.countryId = countryId;
            return this;
        }

        public Builder setCountryName(String countryName){
            this.countryName = countryName;
            return this;
        }

        public Country.Builder copy(Country c){
            this.countryId = c.countryId;
            this.countryName = c.countryName;
            return this;
        }

        public Country build(){
            return new Country(this);
        }



    }
}
