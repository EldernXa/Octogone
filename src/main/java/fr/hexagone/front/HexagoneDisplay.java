package fr.hexagone.front;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Screen;

import java.util.ArrayList;

public class HexagoneDisplay {

    private Polygon shape;
    private Polygon room1;
    private Polygon room2;
    private Polygon room3;

    private ArrayList<RoomDisplay> sallesAffichages;


    public HexagoneDisplay(ArrayList<RoomDisplay> roomDisplays){
        this.shape =  new Polygon();
        this.room1 = new Polygon();
        this.room2 = new Polygon();
        this.room3 = new Polygon();

        double x = Screen.getPrimary().getBounds().getWidth()/2;
        double y =  Screen.getPrimary().getBounds().getHeight()/2;
        shape.getPoints().addAll(
                x,y-300,
                x+Math.sqrt(3/2)*300, y-150,
                x+Math.sqrt(3/2)*300, y+150,
                x, y+300,
                x-Math.sqrt(3/2)*300, y+150,
                x-Math.sqrt(3/2)*300, y-150
        );


        this.shape.setFill(Color.WHITE);
        this.shape.setStroke(Color.BLACK);
        this.shape.setStrokeWidth(this.shape.getStrokeWidth() + 10);

        //TODO initialiser les salles

        shape.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                shape.setFill(Color.BLACK);
                shape.setStroke(Color.RED);
            }
        });


        room1.getPoints().addAll(
                x+10, y-295,
                x+10,y-150,
                x+Math.sqrt(3/2)*300,y-150
        );
        this.room1.setFill(Color.WHITE);
        this.room1.setStroke(Color.BLACK);


        room2.getPoints().addAll(
                x-10, y-295,
                x-10,y-150,
                x-Math.sqrt(3/2)*300,y-150
        );
        this.room2.setFill(Color.WHITE);
        this.room2.setStroke(Color.BLACK);


        room3.getPoints().addAll(
                x-10, y-140,
                x-10,y,
                x-Math.sqrt(3/2)*300,y,
                x-Math.sqrt(3/2)*300,y-140

        );
        this.room3.setFill(Color.WHITE);
        this.room3.setStroke(Color.BLACK);


        this.sallesAffichages = sallesAffichages;


    }


    public Polygon getForme() {
        return shape;
    }

    public Polygon getSalle1() {
        return room1;
    }

    public Polygon getSalle2() {
        return room2;
    }

    public Polygon getSalle3() {Z
        return room3;
    }

    public void setForme(Polygon shape) {
        this.shape = shape;
    }
}
