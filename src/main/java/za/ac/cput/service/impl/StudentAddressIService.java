package za.ac.cput.service.impl;

import za.ac.cput.domain.StudentAddress;
import java.util.*;
public interface StudentAddressIService extends IService<StudentAddress, String> {

    public List<StudentAddress> getAll();

}
