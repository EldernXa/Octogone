package fr.hexagone.model;

import lombok.*;

import javax.decorator.Delegate;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public @Getter @Setter @NoArgsConstructor
class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    @Min(1)
    @Max(16)
    private int capacity;

    @ElementCollection
    private List<String> features = new ArrayList<>();

   
    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER)
    @Singular("reservation")
    List<Reservation> reservations = new ArrayList<>();


    public Room(String name, int capacity, String... features) {
        this.name = name;
        this.capacity = capacity;
        this.features = Arrays.asList(features);
    }

    /**
     * Affecte une réservation à la salle
     * @param r la réservation
     */
    public void addReservation(Reservation r){
        reservations.add(r);
    }



}
