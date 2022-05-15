package ma.hotel.projet.controllers;


import ma.hotel.projet.entities.Reservation;
import ma.hotel.projet.entities.Room;
import ma.hotel.projet.services.ReservationService;
import ma.hotel.projet.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Room> findRoomByReservationId(@PathVariable Integer id) {
        Room room = reservationService.findById(id).getRoom();
        return new ResponseEntity<>(room, HttpStatus.OK);
    }
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return new ResponseEntity<>(reservationService.findAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.saveReservation(reservation), HttpStatus.CREATED);
    }

    @PostMapping("update/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Integer id, @RequestBody Reservation reservation) {
        if (reservationService.findById(id) != null) {
            return new ResponseEntity<>(reservationService.saveReservation(reservation), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Integer id){
        return  new ResponseEntity<>(reservationService.findById(id),HttpStatus.OK);
    }
    

    @GetMapping("/{id}/rooms")
    public ResponseEntity<List<Room>> findRoomsByReservation(@PathVariable Integer id){
        Reservation reservation=reservationService.findById(id);
        return new ResponseEntity<>(reservationService.findRoomsByReservation(reservation),HttpStatus.OK);

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

