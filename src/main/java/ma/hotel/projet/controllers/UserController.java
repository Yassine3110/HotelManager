package ma.hotel.projet.controllers;


import ma.hotel.projet.entities.Role;
import ma.hotel.projet.entities.User;
import ma.hotel.projet.services.RoleService;
import ma.hotel.projet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
