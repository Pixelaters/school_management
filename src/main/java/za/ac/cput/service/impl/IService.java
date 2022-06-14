package za.ac.cput.service.impl;
/*Breyton Ernstzen (217203027)
  ADP3 - June Assessment 2022
  Date: 14 June 2022
  School Management
 */
public interface IService<T,ID> {

    T create(T t);
    T read(ID id);
    //T update(T t);
    void delete(ID id);
}
