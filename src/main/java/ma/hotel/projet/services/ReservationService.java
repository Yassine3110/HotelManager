package ma.hotel.projet.services;

import lombok.RequiredArgsConstructor;
import ma.hotel.projet.entities.Reservation;
import ma.hotel.projet.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.Location;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    public Reservation findById(Integer id){
        return reservationRepository.findById(id).get();
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

}
