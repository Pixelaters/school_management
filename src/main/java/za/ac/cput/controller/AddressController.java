package za.ac.cput.controller;

/*Ziyaad Petersen (219083479)
        ADP3 - June Assessment 2022
        Date: 14 June 2022
        School Management
        */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Address;
import za.ac.cput.service.impl.AddressIService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school_management/address/")
@Slf4j
public class AddressController {

    private final AddressIService addressIService;

    @Autowired
    AddressController(AddressIService addressIService){this.addressIService = addressIService;}

    @PostMapping("save_address")
    public ResponseEntity<Address>create(@Valid @RequestBody Address saveAddress){
        log.info("Save request: {}, saveAddress");

        try{
            Address newAddress= addressIService.create(saveAddress);
            return ResponseEntity.ok(newAddress);
        }catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @GetMapping("getAllEmployees")
    public ResponseEntity<List<Address>> getAll(){
        List<Address> list = this.addressIService.getAll();
        return ResponseEntity.ok(list);
    }
}
