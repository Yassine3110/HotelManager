package ma.hotel.projet.controllers;

import ma.hotel.projet.entities.Room;
import ma.hotel.projet.services.ReservationService;
import ma.hotel.projet.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @Autowired
    ReservationService reservationService;

    @GetMapping("/all")
    public ResponseEntity<List<Room>> findAll(){
        return  new ResponseEntity<>(roomService.findAllRooms(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Room> saveRoom(@RequestBody Room room){
        return new ResponseEntity<>(roomService.saveRoom(room),HttpStatus.CREATED);
    }

    @PostMapping("{id}/update")
    public ResponseEntity<Room> saveRoom(@PathVariable Integer id,@RequestBody Room room){
        Room r = roomService.findById(id);
        if(roomService.findById(id)!=null){
            return new ResponseEntity<>(roomService.saveRoom(room),HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<?> deleteRoom(@PathVariable Integer id){
        roomService.deleteRoom(roomService.findById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
