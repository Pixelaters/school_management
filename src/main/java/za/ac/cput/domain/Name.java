/*
Student Name: Nondumiso Gaga ,Ziyaad Petersen(219083479), Raeece Samuels (217283764), Breyton Ernstzen (217203027)
Student Number: 220430853
Name class


 */


package za.ac.cput.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
public class Name  {//Remove Setters but not in Builder class

    @NotNull
    private String firstName;
    private String middleName;
    @NotNull
    private String lastName;

    protected Name() {
    }

    private Name (Builder builder){
        this.firstName= builder.firstName;
        this.middleName = builder.middleName;
        this.lastName=builder.lastName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name that = (Name) o;
        return firstName.equals(that.firstName)
                && middleName.equals(that.middleName)
                && lastName.equals(that.lastName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);

    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder{
        private String firstName;
        private String middleName;
        private String lastName;

        public Builder FirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder MiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder LastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder copy(Name name){
            this.firstName = name.firstName;
            this.middleName = name.middleName;
            this.lastName = name.lastName;
            return this;
        }
        public Name build(){

            return new Name(this);
        }
    }

}
