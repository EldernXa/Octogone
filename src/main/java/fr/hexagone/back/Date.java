package fr.hexagone.back;

public class Date {

    private int jour;
    private int mois;
    private int annee;
    private int heure;
    private int minute;

    public Date(int annee, int mois, int jour, int heure, int minute){
        this.annee = annee;
        this.mois = mois;
        this.jour = jour;
        this.heure = heure;
        this.minute = minute;
    }

    public Date(int annee,int mois,int jour){
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public Date(int heure, int minute){
        this.heure = heure;
        this.minute = minute;
    }

}
