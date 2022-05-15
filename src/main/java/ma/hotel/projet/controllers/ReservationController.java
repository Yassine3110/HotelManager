package ma.hotel.projet.controllers;


import ma.hotel.projet.entities.Reservation;
import ma.hotel.projet.entities.Room;
import ma.hotel.projet.services.ReservationService;
import ma.hotel.projet.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private RoomService roomService;
    @GetMapping("all")
    public ResponseEntity<List<Reservation>> findAll(){
        return new ResponseEntity<List<Reservation>>(reservationService.findAll(), OK);
    }


    @GetMapping("{id}/room")
    public ResponseEntity<Room> findRoomByReservationId(@PathVariable Integer id){
        Room room = reservationService.findById(id).getRoom();
        return new ResponseEntity<>(room, OK);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<?> deleteReservation(@PathVariable Integer id){
        reservationService.deleteReservation(reservationService.findById(id));
        return new ResponseEntity<>(OK);
    }

    @PutMapping("{id}/{idRoom}/update")
    public ResponseEntity<?> updateReservation(@PathVariable Integer id,@PathVariable Integer idRoom,@RequestBody Reservation reservation){
        Reservation res=reservationService.findById(id);
        Room room =roomService.findById(idRoom);
        reservationService.updateReservationClient(res.getId(),room.getId(),reservation);
        return new ResponseEntity<>(OK);
    }

    @GetMapping("{date}/reservations")
    public ResponseEntity<List<Reservation>> findReservationsByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return new ResponseEntity<>(reservationService.findReservationsByDate(date),OK);
    }






}
