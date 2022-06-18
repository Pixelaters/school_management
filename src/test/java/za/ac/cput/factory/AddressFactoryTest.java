package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Address;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddressFactoryTest {

    ArrayList<Address> address = new ArrayList<>();
    private static final Address address1 = AddressFactory.build("12", "something", "21", "michigan", 2121, CityFactory.buildCity("21", "Cape Town", CountryFactory.builder("21", "South Africa")));
    private static final Address address2 = AddressFactory.build(null, null, "21", "bananaberry", 2122, CityFactory.buildCity("21", "Cape Town", CountryFactory.builder("21", "South Africa")));

    @Order(1)
    @Test
    void firstRunBuild(){
    address.add(address1);
        System.out.println("Added: " + address.get(0));
    address.add(address2);
        System.out.println("Added: " + address.get(1));

        assertAll(
                () -> assertNotNull(address1),
                () -> assertNotNull(address2),
                () -> assertNotNull(address1.getCity()),
                () -> assertNotNull(address2.getCity())
        );
    }

    @Order(2)
    @Test
    void objectEquality(){
        assertAll(
                () -> assertNotEquals(address1.getCity(),address2.getCity()),
                () -> assertNotEquals(address1.getStreetName(),address2.getStreetName()),
                () -> assertNotEquals(address1,address2),
                () -> assertNotNull(address1)
        );

        System.out.println("Equality test passed successfully");
    }

    @Order(3)
    @Test
    void objectIdentity(){
        assertAll(
                () ->  assertNotSame(address1.getCity(),address2.getCity()),
                () ->  assertNotSame(address1.getStreetName(),address2.getStreetName()),
                () ->  assertNotSame(address1,address2),
                () ->  assertNotNull(address1),
                () ->  assertNotNull(address2)

        );
        System.out.println("Identity test pass successfully");
    }


    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> AddressFactory.build("221","","","michigan",8888, null));
        System.out.println(exception.getMessage()); //is it not supposed to make it an empty string?
        //assertTrue(exception.getMessage().contains(""));
    }

    @Test
    void buildWithSuccess(){
        Address address = AddressFactory.build("12","asd","23","highroad",2222, null);
        System.out.println(address);
        assertAll(
                () -> assertNotNull(address),
                () -> assertNotNull(address.getComplexName())
        );
    }




}
