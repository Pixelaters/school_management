package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Name;
import za.ac.cput.repository.NameRepository;
import za.ac.cput.service.NameIService;

import java.util.List;
@Service
public class NameServiceimpl implements NameIService {
    private final NameRepository nameRepository;

    @Autowired
    public NameServiceimpl(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    @Override
    public Name create(Name name) {
        return this.nameRepository.save(name);
    }

    @Override
    public Name read(Name name) {
        return name;
    }


    @Override
    public void delete(Name name) {
         this.nameRepository.delete( name);

    }

    @Override
    public List<Name> getAll() {
        return this.nameRepository.findAll();
    }
}
