package ma.hotel.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "chambre")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer number;
    private Integer floor;
    private Boolean availability=true;
    private String phoneNumber;
    private Double price;
    //reservation
    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    @JsonBackReference
    //@MapsId
    private Type type;


}
