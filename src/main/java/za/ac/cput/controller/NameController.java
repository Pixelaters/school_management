/*
Student Name: Nondumiso Gaga
Student Number: 220430853
NameController
 */

package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Name;
import za.ac.cput.service.NameIService;


import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("school_management/name/")
@Slf4j
public class NameController {

   private final NameIService nameIService;


   @Autowired
   public NameController(NameIService nameIService) {
        this.nameIService =nameIService;

    }
    @PostMapping("save")
    public ResponseEntity<Name> save(@Valid @RequestBody Name name){
        log.info("save request: ", name);
        Name save = nameIService.create(name);
        return ResponseEntity.ok(save);

    }
    @GetMapping("read")
    public ResponseEntity<Name> read(@PathVariable Name name){
       log.info("read request: {}", name);
      // Name name1 = this.nameIService.read(name).ElseThrow(()new ResponseStatusException(HttpStatus.NOT_FOUND));
       return ResponseEntity.ok(name);
    }
    @DeleteMapping("delete")
    public ResponseEntity<Name> delete(@PathVariable Name name){
       log.info("Delete request: {}", name);
       this.nameIService.delete(name);
       return ResponseEntity.noContent().build();
    }


    @GetMapping("Names")
    public ResponseEntity<List<Name>> getAll(){
        List<Name> listNames = this.nameIService.getAll();
        return ResponseEntity.ok(listNames);
    }

}
