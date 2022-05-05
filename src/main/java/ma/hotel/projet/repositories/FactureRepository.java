package ma.hotel.projet.repositories;

import ma.hotel.projet.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Integer> {
}
