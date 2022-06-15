/*Student Name: Nondumiso Gaga
        Student Number: 220430853
        Name class
*/
package za.ac.cput.service;

import za.ac.cput.entity.Name;

import java.util.List;

public interface NameIService extends IServicename<Name,String> {



    public List<Name> getAll();

}
