package ma.hotel.projet.services;

import lombok.RequiredArgsConstructor;
import ma.hotel.projet.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    public ma.hotel.projet.entities.Service addService(ma.hotel.projet.entities.Service service){
        return serviceRepository.save(service);
    }
}
