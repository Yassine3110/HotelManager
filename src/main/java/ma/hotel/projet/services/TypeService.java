package ma.hotel.projet.services;

import lombok.RequiredArgsConstructor;
import ma.hotel.projet.entities.Type;
import ma.hotel.projet.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.validation.TypeInfoProvider;

@Service
@RequiredArgsConstructor
public class TypeService {
    @Autowired
    TypeRepository typeRepository;
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
