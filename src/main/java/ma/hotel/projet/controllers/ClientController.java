package ma.hotel.projet.controllers;

import ma.hotel.projet.entities.Client;
import ma.hotel.projet.entities.Reservation;
import ma.hotel.projet.services.ClientService;
import ma.hotel.projet.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("all")
    public ResponseEntity<List<Client>> getAllClients(){
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        return new ResponseEntity<>(clientService.saveClient(client),HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        return new ResponseEntity<>(clientService.saveClient(client),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer id){
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteClient(@RequestBody Client client){
        if(clientService.findById(client.getId())!=null) {
            List<Reservation> reservations = reservationService.findReservationsByClient(client);
            reservationService.deleteReservations(reservations);
            clientService.deleteClient(client);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("{id}/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations(@PathVariable Integer id){
        return new ResponseEntity<>(clientService.findById(id).getReservations(),HttpStatus.OK);
    }


}
