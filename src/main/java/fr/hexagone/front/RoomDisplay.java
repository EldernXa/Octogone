package fr.hexagone.front;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;

public class RoomDisplay {

    private final Coordinate coordinate;
    private final Polygon shape;
    private final Label nameRoom;
    private final Color colorRoom;

    public RoomDisplay(Coordinate coordinate, Polygon shape, Label nameRoom, Color colorRoom){
        this.coordinate = coordinate;
        this.shape = shape;
        this.nameRoom = nameRoom;
        this.colorRoom = colorRoom;

        this.shape.setLayoutX(this.getX());
        this.shape.setLayoutY(this.getY());
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
}
