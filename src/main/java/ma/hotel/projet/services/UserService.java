package ma.hotel.projet.services;

import lombok.RequiredArgsConstructor;
import ma.hotel.projet.entities.Client;
import ma.hotel.projet.entities.User;
import ma.hotel.projet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User findById(Integer id){
        return userRepository.findById(id).get();
    }
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }


}
