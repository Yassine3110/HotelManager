package ma.hotel.projet.services;

import lombok.RequiredArgsConstructor;
import ma.hotel.projet.entities.Role;
import ma.hotel.projet.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }
    public Role findRoleById(Integer id){
        return roleRepository.findById(id).get();
    }

}
