package fr.hexagone.front;

import fr.hexagone.model.Room;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

import java.awt.*;

public class RoomDisplay {

    private final Room room;
    private StackPane displayPane;
    private final Coordinate coordinate;
    private final Polygon shape;
    private final Label nameRoom;
    private final Color colorRoom;

    public RoomDisplay(Room room, Coordinate coordinate, Polygon shape, Color colorRoom){
        this.room = room;
//        this.displayPane = updatePane();
        this.coordinate = coordinate;
        this.shape = shape;
        this.nameRoom = new Label(this.room.getName());
        this.colorRoom = colorRoom;
        this.shape.setLayoutX(this.getX());
        this.shape.setLayoutY(this.getY());
    }

    public StackPane updatePane(){

        StackPane pane = new StackPane();
        VBox vBox = new VBox();
        pane.setPrefSize(300,300);
        pane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,null,null)));
        pane.setBorder(new Border(new BorderStroke(Color.BLACK,null,null,new BorderWidths(20))));
        Label nameRoom = new Label("Nom de la salle : " + this.room.getName());
        Label capacity = new Label("Capacité de la salle : " + Integer.toString(room.getCapacity()));
        GridPane gridPane = new GridPane();
//        ScrollPane scrollPane = new ScrollPane();

        for(int i = 0; i < room.getReservationsOfWeek().size(); i++){
            gridPane.add(new ReservationDisplay(room.getReservations().get(i)).createReservationDisplay(),i,0);
        }

//        scrollPane.setContent(gridPane);
        vBox.getChildren().addAll(nameRoom,capacity);//add scrollpane
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(30));
        pane.getChildren().add(vBox);
        pane.setLayoutX(calculPosPopUp().getX());//calculPosPopUp().getX()
        pane.setLayoutY(calculPosPopUp().getY());//calculPosPopUp().getY()

        System.out.println();

        return pane;
    }

    private Point calculPosPopUp(){
        Point point = new Point();

        double sCX = Screen.getPrimary().getVisualBounds().getWidth()/2;
        double sCY = Screen.getPrimary().getVisualBounds().getHeight()/2;

        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;

        double maxY = -Double.MAX_VALUE;
        double maxX = -Double.MAX_VALUE;

        for(int i = 0; i < this.shape.getPoints().size(); i++){
            if(i%2 == 0){
                if(this.shape.getPoints().get(i) > maxX){
                    System.out.println("X supp");
                    maxX = this.shape.getPoints().get(i);
                }
                if(this.shape.getPoints().get(i) < minX){
                    System.out.println("X inf");
                    minX = this.shape.getPoints().get(i);
                }
            }
            else{
                if(this.shape.getPoints().get(i) > maxY){
                    System.out.println("Y supp");
                    maxY = this.shape.getPoints().get(i);
                }
                if(this.shape.getPoints().get(i) < minY){
                    System.out.println("Y inf");
                    minY = this.shape.getPoints().get(i);
                }
            }
        }

        point.setLocation(maxX+sCX,maxY+sCY);

        return point;
    }

    public double getX(){
        return this.coordinate.getX();
    }

    public double getY(){
        return this.coordinate.getY();
    }

    public Polygon getShape() {
        return shape;
    }

    public StackPane getDisplayPane() {
        return displayPane;
    }

    public StackPane getAndUpdateDisplayPane() {
        this.displayPane = updatePane();
        return displayPane;
    }

    public void setNullDisplayPane() {
        this.displayPane = null;
    }
}
