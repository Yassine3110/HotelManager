package ma.hotel.projet.repositories;

import ma.hotel.projet.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TypeRepository extends JpaRepository<Type,Integer> {
}
