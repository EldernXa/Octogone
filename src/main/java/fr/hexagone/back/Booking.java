package fr.hexagone.back;

public class Booking {

    private static int ID = 0;
    private Date hStart;
    private int duration;
    private String mail;

    public Booking(Date hStart, int duration, String mail){
        this.hStart = hStart;
        this.duration = duration;
        this.mail = mail;
    }



}
