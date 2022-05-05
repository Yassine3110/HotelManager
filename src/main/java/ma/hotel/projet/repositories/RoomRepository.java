package ma.hotel.projet.repositories;

import ma.hotel.projet.entities.Room;
import ma.hotel.projet.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findByAvailability(Boolean bool);

    Room findByNumber(Integer number);

    List<Room> findByFloorAndAvailability(Integer floor, Boolean availability);

    List<Room> findByPriceBetween(Double priceMin, Double priceMax);

    Room findByPrice(Double price);

    List<Room> findByType(Type type);
}
