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

public class RoomDisplay {

    private final Room room;
    private StackPane displayPane;
    private final Coordinate coordinate;
    private final Polygon shape;
    private final Label nameRoom;
    private final Color colorRoom;

    public RoomDisplay(Room room, Coordinate coordinate, Polygon shape, Color colorRoom){
        this.room = room;
        this.displayPane = updatePane();
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
        pane.setLayoutX(0);
        pane.setLayoutY(0);

        return pane;
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
