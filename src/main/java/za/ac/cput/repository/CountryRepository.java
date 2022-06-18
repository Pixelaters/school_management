package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Country;
/*
Ethan George
student number : 218008430
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {


}
