package fr.hexagone.front;

import fr.hexagone.back.Salle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.stage.Screen;

import java.util.ArrayList;

public class HexagoneAffichage {

    private Polygon forme;
    private ArrayList<SalleAffichage> sallesAffichages;


    public HexagoneAffichage(ArrayList<SalleAffichage> sallesAffichages){
        this.forme =  new Polygon();
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

        //TODO initialiser les salles

        forme.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                forme.setFill(Color.BLACK);
                forme.setStroke(Color.RED);
            }
        });

        this.sallesAffichages = sallesAffichages;
    }

    public Polygon getForme() {
        return forme;
    }

    public void setForme(Polygon forme) {
        this.forme = forme;
    }
}
