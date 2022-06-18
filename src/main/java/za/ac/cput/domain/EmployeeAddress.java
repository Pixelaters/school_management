package za.ac.cput.domain;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
import javax.persistence.*;
import java.util.Objects;

@Entity
public class EmployeeAddress {

    @Id private String staffId;

    @JoinColumn(insertable = false,updatable = false)
    @Embedded
    private Address address; //Note this error *

    protected EmployeeAddress(){
        //constructor
    }

    public EmployeeAddress(Builder b){
        this.staffId = b.staffId;
        this.address = b.address;

    }

    public String getStaffId() {
        return staffId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffId='" + staffId + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EmployeeAddress that = (EmployeeAddress) o;
        return staffId.equals(that.staffId); //take out if it causes an error
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId);//take out if it causes an error
    }

    public static class Builder{
        private String staffId;
        private Address address;

        public Builder staffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(EmployeeAddress ea){
            this.staffId = ea.staffId;
            this.address = ea.address;
            return this;
        }

        public EmployeeAddress build(){
            return new EmployeeAddress(this);
        }
    }
}
