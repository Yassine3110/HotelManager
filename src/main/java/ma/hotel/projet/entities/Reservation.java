package ma.hotel.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private Integer dureeSejour;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @JsonBackReference
    private User user;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    //@JsonManagedReference
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "client_id",nullable = false)
    @JsonBackReference
    private Client client;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "facture_id")
    private Facture facture;


    @ManyToMany
    @JoinTable(
            name = "service_reservation",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id"))
    private List<Service> services;

    public void addServiceToReservation(Service service){
        this.getServices().add(service);
    }







}
