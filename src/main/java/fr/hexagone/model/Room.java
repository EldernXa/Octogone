package fr.hexagone.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id = 0;

    @OneToMany
    List<Reservation> reservations = new ArrayList<>();

    public Room() {}
}
