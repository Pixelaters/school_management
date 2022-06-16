/*Student Name: Nondumiso Gaga
        Student Number: 220430853
        NameServiceimpl.java
*/

package za.ac.cput.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import za.ac.cput.entity.Name;
import za.ac.cput.repository.NameRepository;



import static org.junit.jupiter.api.Assertions.*;

class NameServiceimplTest {

    @Mock
    private NameRepository nameRepository;

    NameServiceimpl nameServiceimpl;
    private static Name name;

    @BeforeEach
    void setUp(){
        nameServiceimpl = new NameServiceimpl(nameRepository);
        name = new Name.Builder()
                .FirstName("Lug")
                .MiddleName("Carol")
                .LastName("Shas")
                .build();

    }

    @Test
    void a_create() {
        nameRepository.save(name);

        assertAll(
                () -> assertNotNull(name.getFirstName()),
                () -> assertNotNull(name.getLastName())

        );

        System.out.println("Name added");
    }

    @Test
    void b_read() {
       nameRepository.getReferenceById(name.getFirstName());

        assertAll(
                () -> assertNotNull(name.getFirstName())
        );

        System.out.println(name.toString());


    }

    @Test
    void c_delete() {
        nameRepository.delete(name);

        assertAll(
                () -> assertNotNull(name.getFirstName())
        );

        System.out.println("Name deleted");
    }

    @Test
    void d_getAll() {
        System.out.println(nameRepository.findAll());
    }
}

