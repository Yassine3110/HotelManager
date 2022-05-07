package ma.hotel.projet;

import lombok.RequiredArgsConstructor;
import ma.hotel.projet.entities.*;
import ma.hotel.projet.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class HotelApplication implements CommandLineRunner{

	@Autowired
	private final ClientService clientService;
	@Autowired
	private final RoomService roomService;
	@Autowired
	private final TypeService typeService;
	@Autowired
	private final ReservationService reservationService;
	@Autowired
	private final UserService userService;
	@Autowired
	private final ServiceService service;
	@Autowired
	private final RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Type t1=new Type();
		t1.setName("suite");
		t1.setNumberOfBeds(4);
		t1.setDescription("formidable");
		t1.setNumberOfpersons(5);
		typeService.saveType(t1);

		Room r1=new Room();
		r1.setType(t1);
		r1.setPhoneNumber("+212678984342");
		r1.setPrice(3000.0);
		r1.setNumber(100);
		r1.setFloor(5);
		r1.setAvailability(true);
		roomService.saveRoom(r1);

		Role ro1=new Role();
		ro1.setName("ADMIN");
		roleService.saveRole(ro1);

		Role ro2=new Role();
		ro2.setName("RECEPTIONNISTE");
		roleService.saveRole(ro2);


		User u1=new User();
		u1.setRole(ro1);
		u1.setUserName("yass12");
		u1.setPassword("hihi");
		u1.setFirstName("yassine");
		u1.setLastName("elh");
		userService.saveUser(u1);

		Client c1=new Client(null,"hamid","serdin","marocain","AS3466","+212754637281","hamid@gmail.com",false,new ArrayList<Reservation>(),u1);
		clientService.saveClient(c1);

	}
}
