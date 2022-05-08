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

	@Autowired
	private final FactureService factureService;

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

		Room r2=new Room();
		r2.setType(t1);
		r2.setPhoneNumber("+2126345555552");
		r2.setPrice(3500.0);
		r2.setNumber(150);
		r2.setFloor(12);
		r2.setAvailability(true);
		roomService.saveRoom(r2);

		Role ro1=new Role();
		ro1.setName("ADMIN");
		roleService.saveRole(ro1);

		Role ro2=new Role();
		ro2.setName("RECEPTIONNISTE");
		roleService.saveRole(ro2);

		Role ro3=new Role();
		ro3.setName("NORMAL");
		roleService.saveRole(ro3);


		User u1=new User();
		u1.setUserName("yass12");
		u1.setPassword("hihuii");
		u1.setFirstName("yassine");
		u1.setLastName("elh");
		userService.saveUser(u1);

		User u2=new User();
		u2.setUserName("aka33");
		u2.setPassword("swsw");
		u2.setFirstName("frfec");
		u2.setLastName("xsxsx");
		userService.saveUser(u2);

		userService.assignRoleToUser(u1,ro2);

		Client c1=new Client(null,"hamid","serdin","marocain","AS3466","+212754637281","hamid@gmail.com",false,new ArrayList<Reservation>());
		Client c2=new Client(null,"manal","breit","marocaine","AS3166","+212432222281","manal@gmail.com",false,new ArrayList<Reservation>());
		clientService.saveClient(c1);
		clientService.saveClient(c2);




		Service service1=new Service(null,"Spa","ra7a",1000.,new ArrayList<>());

		service.addService(service1);

		Reservation reservation=new Reservation(null,LocalDate.of(2022,8,13),LocalTime.of(10,00),10,u1,r1,c1,new Facture(),new ArrayList<Service>());
		reservationService.saveReservation(reservation);

		reservationService.addService(reservation,service1);


		reservationService.updateFactureReservation(reservation);








	}
}
