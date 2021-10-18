package fr.hexagone.front;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

public class RoomDisplay {

    private Coordinate coordinate;
    private Path shape;
    private Label nameRoom;
    private Color colorRoom;

    public RoomDisplay(Coordinate coordinate, Path shape, Label nameRoom, Color colorRoom){
        this.coordinate = coordinate;
        this.shape = shape;
        this.nameRoom = nameRoom;
        this.colorRoom = colorRoom;

        this.shape.setLayoutX(this.getX());
        this.shape.setLayoutY(this.getY());
    }

    public int getX(){
        return this.coordinate.getX();
    }

    public int getY(){
        return this.coordinate.getY();
    }
}
