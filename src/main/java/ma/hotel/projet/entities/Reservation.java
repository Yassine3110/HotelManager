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
@Table(name = "reser")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate reservationDate;
    private LocalTime reservationHour;
    private Integer dureeSejour;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_user",nullable = false)
    private User user;

    @OneToMany(mappedBy = "reservation",cascade=CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Room> rooms;



}
