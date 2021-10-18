package fr.hexagone.front;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Screen;

import java.util.ArrayList;

public class HexagoneAffichage {

    private Polygon forme;
    private Polygon salle1;
    private Polygon salle2;
    private Polygon salle3;

    private ArrayList<SalleAffichage> sallesAffichages;


    public HexagoneAffichage(ArrayList<SalleAffichage> sallesAffichages){
        this.forme =  new Polygon();
        this.salle1 = new Polygon();
        this.salle2 = new Polygon();
        this.salle3 = new Polygon();

        double x = Screen.getPrimary().getBounds().getWidth()/2;
        double y =  Screen.getPrimary().getBounds().getHeight()/2;
        forme.getPoints().addAll(
                x,y-300,
                x+Math.sqrt(3/2)*300, y-150,
                x+Math.sqrt(3/2)*300, y+150,
                x, y+300,
                x-Math.sqrt(3/2)*300, y+150,
                x-Math.sqrt(3/2)*300, y-150
        );


        this.forme.setFill(Color.WHITE);
        this.forme.setStroke(Color.BLACK);
        this.forme.setStrokeWidth(this.forme.getStrokeWidth() + 10);

        //TODO initialiser les salles

        forme.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                forme.setFill(Color.BLACK);
                forme.setStroke(Color.RED);
            }
        });


        salle1.getPoints().addAll(
                x+10, y-295,
                x+10,y-150,
                x+Math.sqrt(3/2)*300,y-150
        );
        this.salle1.setFill(Color.WHITE);
        this.salle1.setStroke(Color.BLACK);


        salle2.getPoints().addAll(
                x-10, y-295,
                x-10,y-150,
                x-Math.sqrt(3/2)*300,y-150
        );
        this.salle2.setFill(Color.WHITE);
        this.salle2.setStroke(Color.BLACK);


        salle3.getPoints().addAll(
                x-10, y-140,
                x-10,y,
                x-Math.sqrt(3/2)*300,y,
                x-Math.sqrt(3/2)*300,y-140

        );
        this.salle3.setFill(Color.WHITE);
        this.salle3.setStroke(Color.BLACK);


        this.sallesAffichages = sallesAffichages;


    }


    public Polygon getForme() {
        return forme;
    }

    public Polygon getSalle1() {
        return salle1;
    }

    public Polygon getSalle2() {
        return salle2;
    }

    public Polygon getSalle3() {
        return salle3;
    }

    public void setForme(Polygon forme) {
        this.forme = forme;
    }
}
