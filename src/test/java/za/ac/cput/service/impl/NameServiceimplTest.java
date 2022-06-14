/*Student Name: Nondumiso Gaga
        Student Number: 220430853
        NameServiceimpl.java
*/

package za.ac.cput.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.Name;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.repository.NameRepository;
import za.ac.cput.service.NameIService;

import static org.junit.jupiter.api.Assertions.*;

class NameServiceimplTest {

    private final Name name = NameFactory.buildName("Lois","","Ping");

    @Autowired
    private NameIService service;




    @Test
    void save() {
        Name saved = this.service.create(this.name);
      assertNotNull(saved);
        System.out.println("name saved");
    }

    @Test
    void read() {

    }

    @Test
    void tearDown() {
        this.service.delete(this.name);
    }

    @Test
    void getAll() {
        

    }
}