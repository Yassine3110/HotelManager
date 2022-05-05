package ma.hotel.projet.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private Integer numberOfBeds;
    private Integer numberOfpersons;
    @OneToMany(mappedBy = "type",cascade=CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonManagedReference
    private List<Room> rooms;

    public void addRoom(Room room){
        this.rooms.add(room);
    }
}
