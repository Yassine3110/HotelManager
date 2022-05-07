package ma.hotel.projet.services;

import ma.hotel.projet.entities.Client;
import ma.hotel.projet.entities.Facture;
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
@Transactional
public class ReservationService {

    private Double Pt;
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FactureService factureService;
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

    public void addService(Reservation reservation, ma.hotel.projet.entities.Service service){
        Reservation r=reservationRepository.findById(reservation.getId()).get();
        r.addServiceToReservation(service);
    }
    public Double calculPt(Reservation reservation){
        Pt=0.;
        Reservation r=reservationRepository.findById(reservation.getId()).get();
        Pt+=r.getRoom().getPrice();
        List<ma.hotel.projet.entities.Service> services=reservationRepository.findById(reservation.getId()).get().getServices();
        services.forEach(x->{
            Pt+=x.getPrice();
        });
        return Pt;
    }

    public void updateFactureReservation(Reservation reservation){
        Facture facture=reservation.getFacture();
        factureService.updatePt(facture,calculPt(reservation));
        //factureService.saveFacture(facture);
    }





}
