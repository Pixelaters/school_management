package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.entity.Address;
import za.ac.cput.repository.AddressIRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 class AddressServiceTest {
    @Mock
    private AddressIRepository addressIRepository;

    AddressService addressService;
    private static Address address1, address2;

    @BeforeEach
    void setUp(){
        addressService = new AddressService(addressIRepository);
        address1 = new Address.Builder()
                .UnitNumber("")
                .ComplexName("")
                .StreetNumber("")
                .StreetName("")
                .PostalCode(3242)
                .City(null)
                .build();

        address2 = new Address.Builder()
                .UnitNumber("32")
                .ComplexName("")
                .StreetNumber("")
                .StreetName("")
                .PostalCode(3242)
                .City(null)
                .build();

    }

    @Order(1)
    @Test
    void create(){
        addressIRepository.save(address1);
        addressIRepository.save(address2);

        assertAll(
                () -> assertNotNull(address1.getStreetNumber()),
                () -> assertNotNull(address1.getStreetName()),
                () -> assertNull(address1.getPostalCode()),
                () -> assertNull(address1.getCity())
        );
        System.out.println("Addresses added");
    }

    //READ AND DELETE????????????????????????????????????????????


    @Order(2)
    @Test
    void getAll(){
        System.out.println(addressIRepository.findAll());
    }

}
