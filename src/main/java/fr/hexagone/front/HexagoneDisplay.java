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
                x-Math.sqrt(3)/2*300, y+150,//j'avais mis sqrt(3/2) au lieu de sqrt(3)/2
                x-Math.sqrt(3)/2*300, y-150
        );
        this.shape.setFill(Color.WHITE);
        this.shape.setStroke(Color.BLACK);
        this.shape.setStrokeWidth(this.shape.getStrokeWidth() + 5);
        shape.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                shape.setFill(Color.BLACK);
                shape.setStroke(Color.RED);
            }
        });

        this.room1 = new Polygon();

        room1.getPoints().addAll(
                0., -297.5,
                0.,-Math.sqrt(2)/2*300.,
                147.5,-Math.sqrt(2)/2*300.
        );
        this.room1.setFill(Color.WHITE);
        this.room1.setStroke(Color.BLACK);
        this.room1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                room1.setFill(Color.RED);
            }
        });
        this.room1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                room1.setFill(Color.WHITE);
            }
        });
        this.roomDisplays.add(new RoomDisplay(new Coordinate(x,y),this.room1,null,Color.WHITE));

        this.room2 = new Polygon();

        room2.getPoints().addAll(
                0., -297.5,
                0.,-Math.sqrt(2)/2*300.,
                -147.5,-Math.sqrt(2)/2*300.
        );
        this.room2.setFill(Color.WHITE);
        this.room2.setStroke(Color.BLACK);
        this.room2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                room2.setFill(Color.RED);
            }
        });
        this.room2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                room2.setFill(Color.WHITE);
            }
        });
        this.roomDisplays.add(new RoomDisplay(new Coordinate(x,y),this.room2,null,Color.WHITE));


        this.room3 = new Polygon();

        room3.getPoints().addAll(
                -147.5,-Math.sqrt(2)/2*300.,
                -73.75,-Math.sqrt(2)/2*300.,
                -73.75,-150.,
                -Math.sqrt(3)/2*300+2.5,-150.

        );
        this.room3.setFill(Color.WHITE);
        this.room3.setStroke(Color.BLACK);
        this.room3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                room3.setFill(Color.RED);
            }
        });
        this.room3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                room3.setFill(Color.WHITE);
            }
        });
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
