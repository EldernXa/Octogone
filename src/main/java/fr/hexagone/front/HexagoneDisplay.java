package fr.hexagone.front;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Screen;

import java.util.ArrayList;

public class HexagoneDisplay {

    private Polygon shape;
    private final Polygon room1;
    private final Polygon room2;
    private final Polygon room3;

    private ArrayList<RoomDisplay> roomDisplays = new ArrayList<>();


    public HexagoneDisplay(){

        double x = Screen.getPrimary().getBounds().getWidth()/2;
        double y =  Screen.getPrimary().getBounds().getHeight()/2;

        this.shape =  new Polygon();

        shape.getPoints().addAll(
                x,y-300,
                x+Math.sqrt(3)/2*300, y-150,
                x+Math.sqrt(3)/2*300, y+150,
                x, y+300,
                x-Math.sqrt(3)/2*300, y+150,
                x-Math.sqrt(3)/2*300, y-150
        );
        this.shape.setFill(Color.WHITE);
        this.shape.setStroke(Color.BLACK);
        this.shape.setStrokeWidth(this.shape.getStrokeWidth() + 5);
        shape.setOnMouseClicked(mouseEvent -> {
            shape.setFill(Color.BLACK);
            shape.setStroke(Color.RED);
        });

        this.room1 = new Polygon();

        room1.getPoints().addAll(
                0., -297.5,
                0.,-225.,
                Math.sqrt(3)/2*150-2.5,-225.
        );
        this.room1.setFill(Color.WHITE);
        this.room1.setStroke(Color.BLACK);
        this.room1.setOnMouseEntered(mouseEvent -> room1.setFill(Color.RED));
        this.room1.setOnMouseExited(mouseEvent -> room1.setFill(Color.WHITE));
        this.roomDisplays.add(new RoomDisplay(new Coordinate(x,y),this.room1,null,Color.WHITE));

        this.room2 = new Polygon();

        room2.getPoints().addAll(
                0., -297.5,
                0.,-225.,
                -Math.sqrt(3)/2*150+2.5,-225.
        );
        this.room2.setFill(Color.WHITE);
        this.room2.setStroke(Color.BLACK);
        this.room2.setOnMouseEntered(mouseEvent -> room2.setFill(Color.RED));
        this.room2.setOnMouseExited(mouseEvent -> room2.setFill(Color.WHITE));
        this.roomDisplays.add(new RoomDisplay(new Coordinate(x,y),this.room2,null,Color.WHITE));


        this.room3 = new Polygon();

        room3.getPoints().addAll(
                -Math.sqrt(3)/2*150+2.5,-225.,
                -(Math.sqrt(3)/2*150+2.5)/2,-225.,
                -(Math.sqrt(3)/2*150+2.5)/2,-150.,
                -Math.sqrt(3)/2*300+2.5,-150.

        );
        this.room3.setFill(Color.WHITE);
        this.room3.setStroke(Color.BLACK);
        this.room3.setOnMouseEntered(mouseEvent -> room3.setFill(Color.RED));
        this.room3.setOnMouseExited(mouseEvent -> room3.setFill(Color.WHITE));
        this.roomDisplays.add(new RoomDisplay(new Coordinate(x,y),this.room3,null,Color.WHITE));


    }


    public Polygon getForme() {
        return shape;
    }

    public void setForme(Polygon shape) {
        this.shape = shape;
    }

    public ArrayList<RoomDisplay> getSallesAffichages() {
        return roomDisplays;
    }

    public void setSallesAffichages(ArrayList<RoomDisplay> roomDisplays) {
        this.roomDisplays = roomDisplays;
    }

    public Polygon getSalle1() {
        return room1;
    }

    public Polygon getSalle2() {
        return room2;
    }

    public Polygon getSalle3() {
        return room3;
    }

}
