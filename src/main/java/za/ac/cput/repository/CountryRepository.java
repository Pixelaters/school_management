package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {


}
