package fr.hexagone.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final int id = 0;

    @Basic(optional = false)
    @Pattern(regexp = "^A-Z[a-z0-9]{2,20}$", message = "Room name must be 3 to 20 letters long alphanumeric characters starting with a capital letter.")
    private String name;

    @Basic(optional = false)
    @Min(1)
    @Max(16)
    private int capacity;

    @ElementCollection
    private List<String> features = new ArrayList<>();

    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER)
    List<Reservation> reservations = new ArrayList<>();

    public Room() {
    }

    public Room(String name, int capacity, String... features) {
        this.name = name;
        this.capacity = capacity;
        this.features = Arrays.asList(features);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<String> getFeatures() {
        return features;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
