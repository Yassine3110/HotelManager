package ma.hotel.projet.controllers;


import ma.hotel.projet.entities.Reservation;
import ma.hotel.projet.entities.Role;
import ma.hotel.projet.entities.User;
import ma.hotel.projet.services.RoleService;
import ma.hotel.projet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping("api")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;



    @PostMapping("role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return new ResponseEntity<>(roleService.saveRole(role), HttpStatus.CREATED);
    }

    @PostMapping("user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("{idUser}/role/{idRole}")
    public void assignRoleToUser(@PathVariable("idUser") Integer idUser,@PathVariable("idRole") Integer idRole){
        User u=userService.findById(idUser);
        Role r=roleService.findRoleById(idRole);
        userService.assignRoleToUser(u,r);
    }

    @GetMapping("role/{idRole}")
    public ResponseEntity<Role> findRoleById(@PathVariable("idRole") Integer idRole){
        Role r=roleService.findRoleById(idRole);
        return new ResponseEntity<>(r,HttpStatus.OK);
    }

    @GetMapping("role/all")
    public ResponseEntity<List<Role>> findAllRoles(){
        List<Role> roles=roleService.findAll();
        return new ResponseEntity<>(roles,HttpStatus.OK);
    }

    @GetMapping("user/all")
    public ResponseEntity<List<User>> Users(){
        List<User> users=userService.findAll();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }


    @GetMapping("user/reservations")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@RequestBody User user){
        List<Reservation> reservations = userService.findById(user.getId()).getReservations();
        return new ResponseEntity<>(reservations,HttpStatus.OK);
    }
}
