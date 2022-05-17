package ma.hotel.projet.services;

import ma.hotel.projet.entities.*;
import ma.hotel.projet.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
public class ReservationService {

    private Double Pt;

    private Integer comparaison;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FactureService factureService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;
    @Autowired
    private ClientService clientService;

    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }
    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    public Reservation findById(Integer id){
        Reservation reservation=reservationRepository.findById(id).get();
        return reservation;
    }
    public void deleteReservation(Reservation reservation){
        reservationRepository.delete(reservation);
    }
    public void deleteReservations(List<Reservation> reservations){
        reservationRepository.deleteAll(reservations);
    }

    public List<Reservation> findReservationByUser(Reservation reservation){
        return reservationRepository.findByUser(reservation.getUser());
    }

    public List<Reservation> findReservationByFacture(Reservation reservation){
        return reservationRepository.findByFacture(reservation);
    }
    public List<Reservation> findReservationsByDate(LocalDate date){
        return reservationRepository.findByDate(date);
    }

    public List<Reservation> findReservationsByDateAndTimeBetween(LocalDate date, LocalTime timeStart, LocalTime timeEnd){
        return reservationRepository.findByDateAndTimeBetween(date,timeStart,timeEnd);
    }
    public List<Reservation> findReservationsByDateAndTime(LocalDate date, LocalTime time) {
        return reservationRepository.findByDateAndTime(date, time);
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
        List<ma.hotel.projet.entities.Service> services=r.getServices();
        services.forEach(x->{
            Pt+=x.getPrice();
        });
        return Pt;
    }

    public void assignRoomToReservation(Room room,Reservation reservation) throws Exception{
        Reservation res=reservationRepository.findById(reservation.getId()).orElseThrow(()->
                new Exception("why god"));
        Room r=roomService.findById(room.getId());
        res.setRoom(r);
        //reservationRepository.save(res);
    }

    public void updateFactureReservation(Reservation reservation){
        Facture facture=reservation.getFacture();
        factureService.updatePt(facture,calculPt(reservation));
        //factureService.saveFacture(facture);
    }
    public void updateReservationClient(Integer idRes,Integer idRoom,Reservation res){
        Reservation reservation=reservationRepository.findById(idRes).get();
        Room room=roomService.findById(idRoom);
        reservation.mapping(res);
        reservationRepository.updateReservation(room,idRes);
    }


}
