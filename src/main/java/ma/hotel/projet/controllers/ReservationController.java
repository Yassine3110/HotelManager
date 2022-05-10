package ma.hotel.projet.controllers;

<<<<<<< HEAD

=======
>>>>>>> 31d932cd9bed5e50bb0d1b9eabb6f3bcda45d406
import ma.hotel.projet.entities.Reservation;
import ma.hotel.projet.entities.Room;
import ma.hotel.projet.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> 31d932cd9bed5e50bb0d1b9eabb6f3bcda45d406
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> main

import java.util.List;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {
<<<<<<< HEAD
=======

>>>>>>> 31d932cd9bed5e50bb0d1b9eabb6f3bcda45d406
    @Autowired
    private ReservationService reservationService;

    @GetMapping("all")
<<<<<<< HEAD
    public ResponseEntity<List<Reservation>> findAll(){
        return new ResponseEntity<List<Reservation>>(reservationService.findAll(),HttpStatus.OK);
    }


    @GetMapping("{id}/room")
    public ResponseEntity<Room> findRoomByReservationId(@PathVariable Integer id){
        Room room = reservationService.findById(id).getRoom();
        return new ResponseEntity<>(room, HttpStatus.OK);
=======
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
>>>>>>> 31d932cd9bed5e50bb0d1b9eabb6f3bcda45d406
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<?> deleteReservation(@PathVariable Integer id){
        reservationService.deleteReservation(reservationService.findById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }





<<<<<<< HEAD
}
=======
}
>>>>>>> 31d932cd9bed5e50bb0d1b9eabb6f3bcda45d406
