package ma.hotel.projet.services;

import ma.hotel.projet.entities.Client;
import ma.hotel.projet.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }
    public Client findById(Integer id){
        return clientRepository.findById(id).get();
    }
    public Client findByCin(String cin){
        return clientRepository.findByCin(cin);
    }
    public void deleteClient(Client client){
        clientRepository.delete(client);
    }




}
