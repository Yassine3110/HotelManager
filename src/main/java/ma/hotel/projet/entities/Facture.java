package ma.hotel.projet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "facture")
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double totalPrice=0.0;

    @OneToOne(mappedBy = "facture")
    @JsonIgnore
    private Reservation reservation;

    //@OneToOne(cascade = CascadeType.ALL, optional = false)
    //@MapsId
    //@JsonManagedReference
    //private Reservation reservation;
}
