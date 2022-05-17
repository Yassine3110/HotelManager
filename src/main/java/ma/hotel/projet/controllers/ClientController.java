package ma.hotel.projet.controllers;

import ma.hotel.projet.entities.*;
import ma.hotel.projet.services.ClientService;
import ma.hotel.projet.services.ReservationService;
import ma.hotel.projet.services.RoomService;
import ma.hotel.projet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private UserService userService;
    @Autowired
    private ClientService clientService;

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private RoomService roomService;

    @GetMapping("all")
    public ResponseEntity<List<Client>> getAllClients(){
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        return new ResponseEntity<>(clientService.saveClient(client),HttpStatus.CREATED);
    }

    @PostMapping("update/{id}")
    public ResponseEntity<Client> updateReservation(@PathVariable Integer id, @RequestBody Client client) {
        if (clientService.findById(id) != null) {
            return new ResponseEntity<>(clientService.saveClient(client), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> findClientById(@PathVariable Integer id){
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<?> deleteClient(@PathVariable Integer id){
        Client client=clientService.findById(id);
        if(clientService.findById(client.getId())!=null) {
            List<Reservation> reservations = reservationService.findReservationsByClient(client);
            reservationService.deleteReservations(reservations);
            clientService.deleteClient(client);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("reservations/{id}")
    public ResponseEntity<List<Reservation>> getAllReservations(@PathVariable Integer id){
        return new ResponseEntity<>(clientService.findById(id).getReservations(),HttpStatus.OK);
    }

    @GetMapping("cin/{cin}")
    public ResponseEntity<Client> findClientByCin(@PathVariable String cin){
        return new ResponseEntity<>(clientService.findByCin(cin),HttpStatus.OK);
    }


    @PostMapping("{idUser}/{idClient}/{idRoom}/addReservation")
    public ResponseEntity<?> addReservationToClient(@PathVariable Integer idUser,@PathVariable Integer idClient,@PathVariable Integer idRoom,@RequestBody Reservation reservation){
        Client client= clientService.findById(idClient);
        Room room = roomService.findById(idRoom);
        if(room.getAvailability()==true) reservation.setRoom(room);
        reservation.setClient(client);
        reservation.setUser(userService.findById(idUser));
        reservation.setFacture(new Facture());
        roomService.findById(reservation.getRoom().getId()).setAvailability(false);
        reservation.setServices(new ArrayList<Service>());
        clientService.addReservationToClient(client,reservation);
        reservationService.updateFactureReservation(reservationService.findById(reservation.getId()));
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
