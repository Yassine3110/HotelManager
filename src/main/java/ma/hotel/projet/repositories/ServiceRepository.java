package ma.hotel.projet.repositories;

import ma.hotel.projet.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ServiceRepository extends JpaRepository<Service,Integer> {
}
