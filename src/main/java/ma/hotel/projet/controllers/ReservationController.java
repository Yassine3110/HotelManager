package ma.hotel.projet.controllers;

import ma.hotel.projet.entities.Reservation;
import ma.hotel.projet.entities.Room;
import ma.hotel.projet.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("all")
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

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteReservation(@PathVariable Integer id){
        Reservation reservation=reservationService.findById(id);
        reservationService.deleteReservation(reservation);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/rooms")
    public ResponseEntity<List<Room>> findRoomsByReservation(@PathVariable Integer id){
        Reservation reservation=reservationService.findById(id);
        return new ResponseEntity<>(reservationService.findRoomsByReservation(reservation),HttpStatus.OK);
    }



}