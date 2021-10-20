package fr.hexagone.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public @Data @NoArgsConstructor
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
    List<Reservation> reservations = new ArrayList<>();

    public Room(String name, int capacity, String... features) {
        this.name = name;
        this.capacity = capacity;
        this.features = Arrays.asList(features);
    }
}
