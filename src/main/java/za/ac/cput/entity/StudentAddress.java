package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Objects;

/*Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
* */
@Entity
public class StudentAddress {
    @Id
    private  String studentId;
    @OneToOne
    @JoinColumn(name = "studAdd_name",nullable = false)
    private  Address address;//Note this error *

    protected StudentAddress(){
        //constructor
    }

    private StudentAddress(Builder b) {
        this.studentId = b.studentId;
        this.address = b.address;
    }

    public String getStudentId() {
        return studentId;
    }

    public Address getAddress() {
        return address;
    }



        @Override
        public String toString() {
            return "Builder{" +
                    "studentId='" + studentId + '\'' +
                    ", address=" + address +
                    '}';
        }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() !=obj.getClass())return false;
        StudentAddress studentAddress = (StudentAddress) obj;
        return studentId.equals(studentAddress.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(studentId);
    }

    public static class Builder{
        private String studentId;
        private Address address;

        public Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(StudentAddress sa){
            this.studentId = sa.studentId;
            this.address = sa.getAddress();
            return this;

        }

        public StudentAddress build(){
            return new StudentAddress(this);
        }
    }
}
