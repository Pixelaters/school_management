package za.ac.cput.entity;

/* Name: Raeece Samuels(217283764)
    Student.java

 */

public class Student {

        private final String studentId, email;
        private final Name name;

        private Student(Builder b) {
            this.studentId = b.studentId;
            this.email = b.email;
            this.name = b.name;
        }

        public String getStudentId() {
            return studentId;
        }

        public String getEmail() {
            return email;
        }

        public Name getName() {
            return name;
        }

        public static class Builder{
            private String studentId, email;
            private Name name;

            public Builder setStudentId(String studentId) {
                this.studentId = studentId;
                return this;
            }

            public Builder setEmail(String email) {
                this.email = email;
                return this;
            }



            public Builder copy(Student s){
                this.studentId = s.studentId;
                this.email = s.email;
                this.name = s.getName();
                return this;

            }

            public Student build(){
                return new Student(this);
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }

            @Override
            public String toString() {
                return "Builder{" +
                        "studentId='" + studentId + '\'' +
                        ", email='" + email + '\'' +
                        ", name=" + name +
                        '}';
            }
        }
    }


