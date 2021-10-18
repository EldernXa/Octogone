package fr.hexagone.back;

import java.util.ArrayList;

public class Salle {

    private String nomSalle;
    private int nbPlace;
    private boolean projecteur = false;
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public Salle(String nomSalle, int nbPlace, boolean projecteur){
        this.nomSalle = nomSalle;
        this.nbPlace = nbPlace;
        this.projecteur = projecteur;
    }
    public Salle(String nomSalle, int nbPlace, boolean projecteur, ArrayList<Reservation> reservations){
        this.nomSalle = nomSalle;
        this.nbPlace = nbPlace;
        this.projecteur = projecteur;
        this.reservations = reservations;
    }


}
