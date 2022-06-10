package za.ac.cput.entity;
/*Name:Raeece Samuels(217283764)
       StudentAddress.java

* */

public class StudentAddress {
    private final String studentId;
    private final Address address;

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

    public static class Builder{
        private String studentId;
        private Address address;

        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(StudentAddress sa){
            this.studentId = sa.studentId;
            this.address = sa.address;
            return this;

        }

        public StudentAddress build(){
            return new StudentAddress(this);
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "studentId='" + studentId + '\'' +
                    ", address=" + address +
                    '}';
        }
    }
}
