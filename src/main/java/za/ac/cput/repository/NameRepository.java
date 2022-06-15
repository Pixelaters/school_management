/*Student Name: Nondumiso Gaga
        Student Number: 220430853
        Name class
*/


package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Name;

import java.util.List;

@Repository
public interface NameRepository extends JpaRepository<Name,String >{

    //List<Name>findByName(String firstName,String lastName);
}
