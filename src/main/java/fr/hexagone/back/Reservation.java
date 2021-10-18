package fr.hexagone.back;

public class Reservation {

    private static int ID = 0;
    private Date hDebut;
    private int duree;
    private String mail;

    public Reservation(Date hDebut, int duree, String mail){
        this.hDebut = hDebut;
        this.duree = duree;
        this.mail = mail;
    }



}
