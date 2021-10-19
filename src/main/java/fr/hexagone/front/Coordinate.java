package fr.hexagone.front;

public class Coordinate {

    private double x;
    private double y;

    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }

    public int getAbscisse() {
        return x;
    }

    public void setAbscisse(int x) {
        this.x = x;
    }

    public int getOrdonnee() {
        return y;
    }

    public void setOrdonnee(int y) {
        this.y = y;
    }
}
