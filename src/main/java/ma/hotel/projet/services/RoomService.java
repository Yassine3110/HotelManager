package ma.hotel.projet.services;


import lombok.RequiredArgsConstructor;
import ma.hotel.projet.entities.Room;
import ma.hotel.projet.entities.Type;
import ma.hotel.projet.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findAllRooms(){
        return roomRepository.findAll();
    }
    public Room saveRoom(Room room){
        return roomRepository.save(room);
    }
    public Room findById(Integer id){
        return roomRepository.findById(id).get();
    }
    public List<Room> findByAvailability(Boolean availability){
        return roomRepository.findByAvailability(availability);
    }
    public Room findByNumber(Integer number){
        return roomRepository.findByNumber(number);
    }
    public List<Room> findByFloorAndAvailability(Integer floor,Boolean availability){
        return roomRepository.findByFloorAndAvailability(floor,availability);
    }
    public List<Room> findByPriceBetween(Double priceMin, Double priceMax){
        return roomRepository.findByPriceBetween(priceMin,priceMax);
    }
    public Room findByPrice(Double price){
        return roomRepository.findByPrice(price);
    }
    public void deleteRoom(Room room){
        roomRepository.delete(room);
    }
    public List<Room> findByType(Type type){
        return roomRepository.findByType(type);
    }



}
