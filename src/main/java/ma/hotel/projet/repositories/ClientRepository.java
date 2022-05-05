package ma.hotel.projet.repositories;

import ma.hotel.projet.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByCin(String cin);
}
