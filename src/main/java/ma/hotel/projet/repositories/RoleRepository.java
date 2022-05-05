package ma.hotel.projet.repositories;

import ma.hotel.projet.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
