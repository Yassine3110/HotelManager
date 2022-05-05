package ma.hotel.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "reser")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate reservationDate;
    private LocalTime reservationHour;
    private Integer dureeSejour;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "reservation",cascade=CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonManagedReference
    private List<Room> rooms;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JsonBackReference
    private Client client;

    @OneToOne
    @JoinColumn(name = "facture_id")
    @JsonManagedReference
    private Facture facture;

    @OneToMany(mappedBy = "reservation")
    @JsonManagedReference
    private List<Service> services;






}
