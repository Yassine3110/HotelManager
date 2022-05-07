package ma.hotel.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double totalPrice=0.0;

    @OneToOne(mappedBy = "facture")
    private Reservation reservation;

    //@OneToOne(cascade = CascadeType.ALL, optional = false)
    //@MapsId
    //@JsonManagedReference
    //private Reservation reservation;
}
