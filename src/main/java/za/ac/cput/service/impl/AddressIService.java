package za.ac.cput.service.impl;

import za.ac.cput.entity.Address;

import java.util.List;

/*Ziyaad Petersen (219083479)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */
public interface AddressIService extends IService<Address, String> {
    public List<Address> getAll();
}
