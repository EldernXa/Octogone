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
    private final Polygon room4;
    private final Polygon room5;
    private final Polygon room6;
    private final Polygon room7;
    private final Polygon room8;
    private final Polygon room9;
    private final Polygon room10;

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

        this.room4 = new Polygon();

        room4.getPoints().addAll(
                -Math.sqrt(3)/2*300+2.5,-150.,
                -150.,-150.,
                -150.,0.,
                -Math.sqrt(3)/2*300+2.5,0.

        );
        this.room4.setFill(Color.WHITE);
        this.room4.setStroke(Color.BLACK);
        this.room4.setOnMouseEntered(mouseEvent -> room4.setFill(Color.RED));
        this.room4.setOnMouseExited(mouseEvent -> room4.setFill(Color.WHITE));
        this.roomDisplays.add(new RoomDisplay(new Coordinate(x,y),this.room4,null,Color.WHITE));

        this.room5 = new Polygon();

        room5.getPoints().addAll(
                -Math.sqrt(3)/2*300+2.5,0.,
                -150.,0.,
                -150.,150.,
                -Math.sqrt(3)/2*300+2.5,150.
        );
        this.room5.setFill(Color.WHITE);
        this.room5.setStroke(Color.BLACK);
        this.room5.setOnMouseEntered(mouseEvent -> room5.setFill(Color.RED));
        this.room5.setOnMouseExited(mouseEvent -> room5.setFill(Color.WHITE));
        this.roomDisplays.add(new RoomDisplay(new Coordinate(x,y),this.room5,null,Color.WHITE));

        this.room6 = new Polygon();

        room6.getPoints().addAll(
                Math.sqrt(3)/2*150-2.5,-225.,
                (Math.sqrt(3)/2*150+2.5)/2,-225.,
                (Math.sqrt(3)/2*150+2.5)/2,-150.,
                Math.sqrt(3)/2*300-2.5,-150.
        );
        this.room6.setFill(Color.WHITE);
        this.room6.setStroke(Color.BLACK);
        this.room6.setOnMouseEntered(mouseEvent -> room6.setFill(Color.RED));
        this.room6.setOnMouseExited(mouseEvent -> room6.setFill(Color.WHITE));
        this.roomDisplays.add(new RoomDisplay(new Coordinate(x,y),this.room6,null,Color.WHITE));

        this.room7 = new Polygon();

        room7.getPoints().addAll(
                Math.sqrt(3)/2*300-2.5,-150.,
                150.,-150.,
                150.,0.,
                Math.sqrt(3)/2*300-2.5,0.

        );
        this.room7.setFill(Color.WHITE);
        this.room7.setStroke(Color.BLACK);
        this.room7.setOnMouseEntered(mouseEvent -> room7.setFill(Color.RED));
        this.room7.setOnMouseExited(mouseEvent -> room7.setFill(Color.WHITE));
        this.roomDisplays.add(new RoomDisplay(new Coordinate(x,y),this.room7,null,Color.WHITE));

        this.room8 = new Polygon();

        room8.getPoints().addAll(
                Math.sqrt(3)/2*300-2.5,0.,
                150.,0.,
                150.,150.,
                Math.sqrt(3)/2*300-2.5,150.
        );
        this.room8.setFill(Color.WHITE);
        this.room8.setStroke(Color.BLACK);
        this.room8.setOnMouseEntered(mouseEvent -> room8.setFill(Color.RED));
        this.room8.setOnMouseExited(mouseEvent -> room8.setFill(Color.WHITE));
        this.roomDisplays.add(new RoomDisplay(new Coordinate(x,y),this.room8,null,Color.WHITE));

        this.room9 = new Polygon();

        room9.getPoints().addAll(
                -Math.sqrt(3)/2*150+2.5,225.,
                -(Math.sqrt(3)/2*150-2.5)/2,225.,
                -(Math.sqrt(3)/2*150-2.5)/2,150.,
                -Math.sqrt(3)/2*300+2.5,150.
        );
        this.room9.setFill(Color.WHITE);
        this.room9.setStroke(Color.BLACK);
        this.room9.setOnMouseEntered(mouseEvent -> room9.setFill(Color.RED));
        this.room9.setOnMouseExited(mouseEvent -> room9.setFill(Color.WHITE));
        this.roomDisplays.add(new RoomDisplay(new Coordinate(x,y),this.room9,null,Color.WHITE));

        this.room10 = new Polygon();

        room10.getPoints().addAll(
                Math.sqrt(3)/2*150-2.5,225.,
                (Math.sqrt(3)/2*150+2.5)/2,225.,
                (Math.sqrt(3)/2*150+2.5)/2,150.,
                Math.sqrt(3)/2*300-2.5,150.
        );
        this.room10.setFill(Color.WHITE);
        this.room10.setStroke(Color.BLACK);
        this.room10.setOnMouseEntered(mouseEvent -> room10.setFill(Color.RED));
        this.room10.setOnMouseExited(mouseEvent -> room10.setFill(Color.WHITE));
        this.roomDisplays.add(new RoomDisplay(new Coordinate(x,y),this.room10,null,Color.WHITE));

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
