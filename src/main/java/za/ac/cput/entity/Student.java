package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/* Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
 */
@Entity
public class Student {
        @Id
        private String studentId;
        @NotNull
        private  String email;
        @OneToOne
        @JoinColumn(name = "stud_name",nullable = false)
        private  Name name;//Note this error*

        protected Student(){
            //constructor
        }

        private Student(Builder b) {
            this.studentId = b.studentId;
            this.email = b.email;
            //this.name = b.name;
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

    @Override
    public String toString() {
        return "Builder{" +
                "studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                '}';
    }



            @Override
            public boolean equals(Object obj) {
               if (this == obj) return true;
               if (obj == null || getClass() !=obj.getClass()) return false;
               Student student = (Student) obj;
               return studentId.equals(student.studentId);
            }

            @Override
            public int hashCode() {
                return Objects.hashCode(studentId);
            }


    public static class Builder{
        private String studentId;
        private String email;
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
        }
    }


