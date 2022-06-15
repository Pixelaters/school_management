package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Address;

@Repository
public interface AddressIRepository extends JpaRepository<Address, String> {
}
