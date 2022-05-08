package ma.hotel.projet.services;

import ma.hotel.projet.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<ma.hotel.projet.entities.Service> findAll(){
        return serviceRepository.findAll();
    }
    public ma.hotel.projet.entities.Service addService(ma.hotel.projet.entities.Service service){
        return serviceRepository.save(service);
    }
    public ma.hotel.projet.entities.Service findServiceById(Integer id){
        return serviceRepository.findById(id).get();
    }
    public void deleteServicec(ma.hotel.projet.entities.Service service){
        serviceRepository.delete(service);
    }
}
