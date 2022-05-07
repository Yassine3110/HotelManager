package ma.hotel.projet.repositories;

import ma.hotel.projet.entities.Client;
import ma.hotel.projet.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
}
