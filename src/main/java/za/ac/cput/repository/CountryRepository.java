package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {


}
