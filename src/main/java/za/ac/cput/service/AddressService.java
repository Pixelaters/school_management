package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Address;
import za.ac.cput.repository.AddressIRepository;
import za.ac.cput.service.impl.AddressIService;

import java.util.List;

@Service
public class AddressService implements AddressIService {

    private final AddressIRepository addressIRepository;
    @Autowired
    public AddressService(AddressIRepository addressIRepository){this.addressIRepository= addressIRepository;}

    @Override
    public Address create(Address address) {
        return null;
    }

    @Override
    public Address read(String s) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<Address> getAll() {
        return null;
    }
}
