package za.ac.cput.entity;

//Ethan George
//Student Number :218008430

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Embeddable
public class Country {


    @Id
    //@SequenceGenerator(name = "city_sequence",sequenceName = "city_sequence",allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "city_sequence")
    private String id;

    @NotNull
    private String name;



    protected Country(String id, String name) {

    }

    private Country(Builder b){
        this.id = b.id;
        this.name = b.name;
    }

    public Country() {

    }

    public String getId() {
        return id;
    }

    public void setId(String countryId) {
        this.id = countryId;
    }



    public String getName() {
        return name;
    }

    public void setName(String countryName) {
        this.name = countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                " Country id='" + id + '\'' +
                ", countryName='" + name + '\'' +
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
        private String id;
        private String name;

        public Builder setId(String id){
            this.id = id;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Country.Builder copy(Country c){
            this.id = c.id;
            this.name = c.name;
            return this;
        }

        public Country build(){
            return new Country(this);
        }



    }
}
