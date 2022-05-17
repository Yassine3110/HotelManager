package ma.hotel.projet.repositories;

import ma.hotel.projet.entities.Client;
import ma.hotel.projet.entities.Reservation;
import ma.hotel.projet.entities.Room;
import ma.hotel.projet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    List<Reservation> findByDate(LocalDate date);

    List<Reservation> findByDateAndTimeBetween(LocalDate date, LocalTime timeStart, LocalTime timeEnd);

    List<Reservation> findByDateAndTime(LocalDate date, LocalTime time);

    List<Reservation> findByClient(Client client);

    List<Reservation> findByDureeSejour(Integer duree);

    List<Reservation> findByUser(User user);

    List<Reservation> findByFacture(Reservation reservation);

    Reservation findByRoom(Room room);

    @Modifying
    @Transactional
    @Query("update Reservation r set r.room=:room where r.id = :id")
    public void updateReservation(@Param(value = "room") Room room,@Param(value = "id") Integer id);

}
