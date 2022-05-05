package ma.hotel.projet;

import lombok.RequiredArgsConstructor;
import ma.hotel.projet.entities.Room;
import ma.hotel.projet.entities.Type;
import ma.hotel.projet.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class HotelApplication implements CommandLineRunner {

	@Autowired
	ClientService clientService;
	@Autowired
	RoomService roomService;
	@Autowired
	TypeService typeService;
	@Autowired
	ReservationService reservationService;
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Room r1=new Room();
		r1.setNumber(100);
		r1.setAvailability(true);
		r1.setFloor(2);
		r1.setPrice(1000.0);
		r1.setPhoneNumber("+212611296556");
		r1.setType(typeService.findById(1));
		roomService.saveRoom(r1);

		Type t=new Type();
		t.setName("suite");
		t.setDescription("une grande chambre");
		t.setNumberOfBeds(4);
		t.setNumberOfpersons(6);
		t.addRoom(r1);
		typeService.saveType(t);







	}
}
