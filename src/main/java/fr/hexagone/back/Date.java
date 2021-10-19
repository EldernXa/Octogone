package fr.hexagone.back;

public class Date {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    public Date(int year, int month, int day, int hour, int minute){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public Date(int year,int month,int day){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

}
