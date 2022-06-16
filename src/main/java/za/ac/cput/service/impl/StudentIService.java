package za.ac.cput.service.impl;

import za.ac.cput.entity.Student;
import java.util.List;
/*
*  Raeece Samuels (217283764)
  ADP3 - June Assessment 2022
  Date: 9 June 2022
  School Management
* */
public interface StudentIService extends IService<Student, String> {
    public List<Student> getAll();

}
