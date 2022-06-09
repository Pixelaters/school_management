package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Objects;

/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */

@Entity
public class EmployeeAddress {

    @Id private String staffId;
    @OneToOne
    @JoinColumn(name = "emp_address",nullable = false)
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeAddress that = (EmployeeAddress) o;
        return staffId.equals(that.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId);
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
