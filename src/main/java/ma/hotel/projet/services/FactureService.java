package ma.hotel.projet.services;

import ma.hotel.projet.entities.Facture;
import ma.hotel.projet.entities.Reservation;
import ma.hotel.projet.repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    public List<Facture> getAll(){
        return factureRepository.findAll();
    }
    public Facture saveFacture(Facture facture){
        return factureRepository.save(facture);
    }
    public void deleteFacture(Facture facture){
         factureRepository.delete(facture);
    }

    public Facture findFactureById(Integer id){
        return factureRepository.findById(id).get();
    }
    public void updatePt(Facture facture,Double totalPt){
        Facture f =factureRepository.findById(facture.getId()).get();
        f.setTotalPrice(totalPt);
    }



}
