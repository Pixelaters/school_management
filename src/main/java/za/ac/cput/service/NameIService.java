/*Student Name: Nondumiso Gaga
        Student Number: 220430853
        Name class
*/
package za.ac.cput.service;

import za.ac.cput.domain.Name;

import java.util.List;

public interface NameIService extends IServicename<Name,String> {//Read class in impl package it should explain this



    public List<Name> getAll();

}
