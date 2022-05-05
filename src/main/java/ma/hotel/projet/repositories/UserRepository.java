package ma.hotel.projet.repositories;

import ma.hotel.projet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
