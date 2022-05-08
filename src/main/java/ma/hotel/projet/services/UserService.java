package ma.hotel.projet.services;

import ma.hotel.projet.entities.Client;
import ma.hotel.projet.entities.Role;
import ma.hotel.projet.entities.User;
import ma.hotel.projet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User findById(Integer id){
        return userRepository.findById(id).get();
    }
    public User findByUsername(String username){
        return userRepository.findByUserName(username);
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }


    public void assignRoleToUser(User user,Role role){
        User u=userRepository.findById(user.getId()).get();
        u.assignRole(role);
        //userRepository.save(user); ==> transactional ;)
    }



}
