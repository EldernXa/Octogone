package fr.hexagone.front;

import fr.hexagone.back.RoomController;
import fr.hexagone.utility.BeanUtil;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import org.w3c.dom.css.Rect;

import java.util.ArrayList;


public class HexagoneDisplay {

    RoomController rc = BeanUtil.getBean(RoomController.class);

    private Pane mainPane;
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


    public HexagoneDisplay(Pane mainPane){

        this.mainPane = mainPane;

        this.mainPane.getChildren().add(new Form());

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
        RoomDisplay roomDisplay = new RoomDisplay(rc.getRoom("H1"),new Coordinate(x,y),this.room1,Color.WHITE);
        this.roomDisplays.add(roomDisplay);

        this.room1.setOnMouseEntered(mouseEvent -> {
            mainPane.getChildren().add(roomDisplay.getAndUpdateDisplayPane());
            System.out.println("Taille de la liste : " + mainPane.getChildren().size());
            System.out.println("Ajout");
        });

        this.room1.setOnMouseExited(mouseEvent -> {
            mainPane.getChildren().remove(roomDisplay.getDisplayPane());
            System.out.println("Taille de la liste : " + mainPane.getChildren().size());
            System.out.println("Retrait");
        });

        this.room2 = new Polygon();

        room2.getPoints().addAll(
                0., -297.5,
                0.,-225.,
                -Math.sqrt(3)/2*150+2.5,-225.
        );
        this.room2.setFill(Color.WHITE);
        this.room2.setStroke(Color.BLACK);
        RoomDisplay roomDisplay2 = (new RoomDisplay(rc.getRoom("H2"),new Coordinate(x,y),this.room2,Color.WHITE));
        this.roomDisplays.add(roomDisplay2);

        this.room2.setOnMouseEntered(mouseEvent -> {
            mainPane.getChildren().add(roomDisplay2.getAndUpdateDisplayPane());
        });

        this.room2.setOnMouseExited(mouseEvent -> {
            mainPane.getChildren().remove(roomDisplay2.getDisplayPane());
        });



        this.room3 = new Polygon();

        room3.getPoints().addAll(
                -Math.sqrt(3)/2*150+2.5,-225.,
                -(Math.sqrt(3)/2*150+2.5)/2,-225.,
                -(Math.sqrt(3)/2*150+2.5)/2,-150.,
                -Math.sqrt(3)/2*300+2.5,-150.

        );
        this.room3.setFill(Color.WHITE);
        this.room3.setStroke(Color.BLACK);
        RoomDisplay roomDisplay3 = (new RoomDisplay(rc.getRoom("H3"),new Coordinate(x,y),this.room3,Color.WHITE));
        this.roomDisplays.add(roomDisplay3);

        this.room3.setOnMouseEntered(mouseEvent -> {
            mainPane.getChildren().add(roomDisplay3.getAndUpdateDisplayPane());
        });

        this.room3.setOnMouseExited(mouseEvent -> {
            mainPane.getChildren().remove(roomDisplay3.getDisplayPane());
        });

        this.room4 = new Polygon();

        room4.getPoints().addAll(
                -Math.sqrt(3)/2*300+2.5,-150.,
                -150.,-150.,
                -150.,0.,
                -Math.sqrt(3)/2*300+2.5,0.

        );
        this.room4.setFill(Color.WHITE);
        this.room4.setStroke(Color.BLACK);
        RoomDisplay roomDisplay4 = (new RoomDisplay(rc.getRoom("H4"),new Coordinate(x,y),this.room4,Color.WHITE));
        this.roomDisplays.add(roomDisplay4);

        this.room4.setOnMouseEntered(mouseEvent -> {
            mainPane.getChildren().add(roomDisplay4.getAndUpdateDisplayPane());
        });

        this.room4.setOnMouseExited(mouseEvent -> {
            mainPane.getChildren().remove(roomDisplay4.getDisplayPane());
        });

        this.room5 = new Polygon();

        room5.getPoints().addAll(
                -Math.sqrt(3)/2*300+2.5,0.,
                -150.,0.,
                -150.,150.,
                -Math.sqrt(3)/2*300+2.5,150.
        );
        this.room5.setFill(Color.WHITE);
        this.room5.setStroke(Color.BLACK);
        RoomDisplay roomDisplay5 = (new RoomDisplay(rc.getRoom("O4"),new Coordinate(x,y),this.room5,Color.WHITE));
        this.roomDisplays.add(roomDisplay5);

        this.room5.setOnMouseEntered(mouseEvent -> {
            mainPane.getChildren().add(roomDisplay5.getAndUpdateDisplayPane());
        });

        this.room5.setOnMouseExited(mouseEvent -> {
            mainPane.getChildren().remove(roomDisplay5.getDisplayPane());
        });

        this.room6 = new Polygon();

        room6.getPoints().addAll(
                Math.sqrt(3)/2*150-2.5,-225.,
                (Math.sqrt(3)/2*150+2.5)/2,-225.,
                (Math.sqrt(3)/2*150+2.5)/2,-150.,
                Math.sqrt(3)/2*300-2.5,-150.
        );
        this.room6.setFill(Color.WHITE);
        this.room6.setStroke(Color.BLACK);
        RoomDisplay roomDisplay6 = (new RoomDisplay(rc.getRoom("O8"),new Coordinate(x,y),this.room6,Color.WHITE));
        this.roomDisplays.add(roomDisplay6);

        this.room6.setOnMouseEntered(mouseEvent -> {
            mainPane.getChildren().add(roomDisplay6.getAndUpdateDisplayPane());
        });

        this.room6.setOnMouseExited(mouseEvent -> {
            mainPane.getChildren().remove(roomDisplay6.getDisplayPane());
        });

        this.room7 = new Polygon();

        room7.getPoints().addAll(
                Math.sqrt(3)/2*300-2.5,-150.,
                150.,-150.,
                150.,0.,
                Math.sqrt(3)/2*300-2.5,0.

        );
        this.room7.setFill(Color.WHITE);
        this.room7.setStroke(Color.BLACK);
        RoomDisplay roomDisplay7 = (new RoomDisplay(rc.getRoom("P1"),new Coordinate(x,y),this.room7,Color.WHITE));
        this.roomDisplays.add(roomDisplay7);

        this.room7.setOnMouseEntered(mouseEvent -> {
            mainPane.getChildren().add(roomDisplay7.getAndUpdateDisplayPane());
        });

        this.room7.setOnMouseExited(mouseEvent -> {
            mainPane.getChildren().remove(roomDisplay7.getDisplayPane());
        });

        this.room8 = new Polygon();

        room8.getPoints().addAll(
                Math.sqrt(3)/2*300-2.5,0.,
                150.,0.,
                150.,150.,
                Math.sqrt(3)/2*300-2.5,150.
        );
        this.room8.setFill(Color.WHITE);
        this.room8.setStroke(Color.BLACK);
        RoomDisplay roomDisplay8 = (new RoomDisplay(rc.getRoom("P2"),new Coordinate(x,y),this.room8,Color.WHITE));
        this.roomDisplays.add(roomDisplay8);

        this.room8.setOnMouseEntered(mouseEvent -> {
            mainPane.getChildren().add(roomDisplay8.getAndUpdateDisplayPane());
        });

        this.room8.setOnMouseExited(mouseEvent -> {
            mainPane.getChildren().remove(roomDisplay8.getDisplayPane());
        });

        this.room9 = new Polygon();

        room9.getPoints().addAll(
                -Math.sqrt(3)/2*150+2.5,225.,
                -(Math.sqrt(3)/2*150-2.5)/2,225.,
                -(Math.sqrt(3)/2*150-2.5)/2,150.,
                -Math.sqrt(3)/2*300+2.5,150.
        );
        this.room9.setFill(Color.WHITE);
        this.room9.setStroke(Color.BLACK);
        RoomDisplay roomDisplay9 = (new RoomDisplay(rc.getRoom("F2"),new Coordinate(x,y),this.room9,Color.WHITE));
        this.roomDisplays.add(roomDisplay9);

        this.room9.setOnMouseEntered(mouseEvent -> {
            mainPane.getChildren().add(roomDisplay9.getAndUpdateDisplayPane());
        });

        this.room9.setOnMouseExited(mouseEvent -> {
            mainPane.getChildren().remove(roomDisplay9.getDisplayPane());
        });

        this.room10 = new Polygon();

        room10.getPoints().addAll(
                Math.sqrt(3)/2*150-2.5,225.,
                (Math.sqrt(3)/2*150+2.5)/2,225.,
                (Math.sqrt(3)/2*150+2.5)/2,150.,
                Math.sqrt(3)/2*300-2.5,150.
        );
        this.room10.setFill(Color.WHITE);
        this.room10.setStroke(Color.BLACK);
        RoomDisplay roomDisplay10= (new RoomDisplay(rc.getRoom("F3"),new Coordinate(x,y),this.room10,Color.WHITE));
        this.roomDisplays.add(roomDisplay10);

        this.room10.setOnMouseEntered(mouseEvent -> {
            mainPane.getChildren().add(roomDisplay10.getAndUpdateDisplayPane());
        });

        this.room10.setOnMouseExited(mouseEvent -> {
            mainPane.getChildren().remove(roomDisplay10.getDisplayPane());
        });


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
