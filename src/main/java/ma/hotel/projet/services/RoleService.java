package ma.hotel.projet.services;

import ma.hotel.projet.entities.Role;
import ma.hotel.projet.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll(){
        return roleRepository.findAll();
    }
    public Role saveRole(Role role){
        return roleRepository.save(role);
    }
    public Role findRoleById(Integer id){
        return roleRepository.findById(id).get();
    }


}
