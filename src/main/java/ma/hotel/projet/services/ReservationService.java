package ma.hotel.projet.services;

import lombok.RequiredArgsConstructor;
import ma.hotel.projet.entities.Client;
import ma.hotel.projet.entities.Reservation;
import ma.hotel.projet.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    public Optional<Reservation> findById(Integer id){
        Optional<Reservation> reservation=reservationRepository.findById(id);
        if(reservation.isPresent()) return reservation;
        return null;
    }
    public List<Reservation> findReservationsByDate(LocalDate date){
        return reservationRepository.findByDate(date);
    }

    public List<Reservation> findReservationsByDateAndTimeBetween(LocalDate date, LocalTime timeStart, LocalTime timeEnd){
        return reservationRepository.findByDateAndTimeBetween(date,timeStart,timeEnd);
    }
    public List<Reservation> findReservationsByDateAndTime(LocalDate date, LocalTime time){
        return reservationRepository.findByDateAndTime(date,time);
    }
    public void DeleteReservation(Reservation reservation){
        reservationRepository.delete(reservation);
    }

    public List<Reservation> findReservationsByClient(Client client){
        return reservationRepository.findByClient(client);
    }
    public List<Reservation> findReservationByDureeDeSejour(Integer duree){
        return reservationRepository.findByDureeSejour(duree);
    }
}
