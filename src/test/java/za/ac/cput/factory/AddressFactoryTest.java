package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Address;

import static org.junit.jupiter.api.Assertions.*;

public class AddressFactoryTest {
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> AddressFactory.build("221","","",2,"", null));
        System.out.println(exception.getMessage()); //is it not supposed to make it an empty string?
        //assertTrue(exception.getMessage().contains(""));
    }

    @Test
    void buildWithSuccess(){
        Address address = AddressFactory.build("12","asd","23",7777,"iuyygugy", null);
        System.out.println(address);
        assertAll(
                () -> assertNotNull(address),
                () -> assertNotNull(address.getComplexName())
        );
    }
}
