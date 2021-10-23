package fr.hexagone.front;

import fr.hexagone.model.Reservation;
import fr.hexagone.model.Room;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;

public class RoomDisplay {

    private final Room room;
    Pane diplayPane;
    private final Coordinate coordinate;
    private final Polygon shape;
    private final Label nameRoom;
    private final Color colorRoom;

    public RoomDisplay(Room room, Coordinate coordinate, Polygon shape, Color colorRoom){
        this.room = room;
        this.diplayPane = createPane();
        this.coordinate = coordinate;
        this.shape = shape;
        this.nameRoom = new Label(this.room.getName());
        this.colorRoom = colorRoom;
        this.shape.setLayoutX(this.getX());
        this.shape.setLayoutY(this.getY());
    }

    public Pane createPane(){
        Pane pane = new Pane();
        VBox vBox = new VBox();
        pane.setPrefSize(450,500);
        Label nameRoom = new Label(this.room.getName());
        Label capacity = new Label(Integer.toString(room.getCapacity()));
        GridPane gridPane = new GridPane();
        ScrollPane scrollPane = new ScrollPane();

        for(int i = 0; i < room.getReservationsOfWeek().size(); i++){
            gridPane.add(new ReservationDisplay(room.getReservations().get(i)).createReservationDisplay(),i,0);
        }

        scrollPane.setContent(gridPane);
        vBox.getChildren().addAll(nameRoom,capacity,scrollPane);
        pane.getChildren().add(vBox);

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

    public Pane getDiplayPane() {
        return diplayPane;
    }
}
