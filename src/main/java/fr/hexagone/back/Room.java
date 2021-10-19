package fr.hexagone.back;

import java.util.ArrayList;

public class Room {

    private String nameRoom;
    private int nbPlace;
    private boolean projector = false;
    private ArrayList<Booking> bookings = new ArrayList<>();

    public Room(String nameRoom, int nbPlace, boolean projector){
        this.nameRoom = nameRoom;
        this.nbPlace = nbPlace;
        this.projector = projector;
    }
    public Room(String nameRoom, int nbPlace, boolean projector, ArrayList<Booking> bookings){
        this.nameRoom = nameRoom;
        this.nbPlace = nbPlace;
        this.projector = projector;
        this.bookings = bookings;
    }


}
