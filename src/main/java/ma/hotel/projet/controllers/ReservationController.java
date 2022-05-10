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
    public ResponseEntity<List<Reservation>> findAll(){
        return new ResponseEntity<List<Reservation>>(reservationService.findAll(),HttpStatus.OK);
    }


    @GetMapping("{id}/room")
    public ResponseEntity<Room> findRoomByReservationId(@PathVariable Integer id){
        Room room = reservationService.findById(id).getRoom();
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<?> deleteReservation(@PathVariable Integer id){
        reservationService.deleteReservation(reservationService.findById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
