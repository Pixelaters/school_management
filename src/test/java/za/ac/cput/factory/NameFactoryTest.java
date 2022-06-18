/*
Student Name: Nondumiso Gaga
Student Number: 220430853
NameFactoryTest  class to test NameFactory
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {

    @Test
   void testName (){ //all attributes are provided


        Name name= NameFactory.buildName("Candice","Keli","Booi");
        assertNotNull(name);


    }

    @Test
    void testMiddleName(){ // testing when middle name is not provided


        Name name= NameFactory.buildName("Amanda","","Naka");
        assertNotNull(name);


    }
  //  @Test
  //  void testNameError (){ //testing if it  will give error when firstName is ot provided,since it is mandatory


      //  Name name= NameFactory.buildName("","","Naka");
     //   assertNotNull(name);


  //  }
}







