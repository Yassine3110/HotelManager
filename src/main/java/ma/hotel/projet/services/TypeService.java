package ma.hotel.projet.services;

import ma.hotel.projet.entities.Type;
import ma.hotel.projet.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;
    public Type saveType(Type type){
        return typeRepository.save(type);
    }
    public Type findById(Integer id){
        return typeRepository.findById(id).get();
    }
    public void deleteType(Type type){
        typeRepository.delete(type);
    }
}
