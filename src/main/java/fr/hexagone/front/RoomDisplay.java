package fr.hexagone.front;

import fr.hexagone.back.HexagoneController;
import fr.hexagone.model.Room;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Screen;

import java.awt.*;

public class RoomDisplay {

    private final Room room;
    private StackPane displayPane;
    private Label labelNameRoomFix;
    private final Coordinate coordinate;
    private final Polygon shape;
    private Color colorRoom;

    public RoomDisplay(Room room, Coordinate coordinate, Polygon shape) {
        this.room = room;
        this.coordinate = coordinate;
        this.shape = shape;
        this.labelNameRoomFix = new Label(this.room.getName());

        setColorRoom(Color.WHITE);

        this.shape.setLayoutX(this.getX());
        this.shape.setLayoutY(this.getY());

    }

    public StackPane updatePane() {

        StackPane pane = new StackPane();
        pane.setPrefSize(320, 300);
        pane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));

        GridPane gridPane = new GridPane();
        VBox vBox = new VBox();

        Label nameRoom = new Label("Nom de la salle : " + this.room.getName());
        Label capacity = new Label("Capacité de la salle : " + Integer.toString(room.getCapacity()));

        gridPane.add(new Label("Reservations"),0,0,4,1);
        gridPane.add(new Label("ID"),0,1);
        gridPane.add(new Label("Début"),1,1);
        gridPane.add(new Label("Fin"),2,1);
        gridPane.add( new Label("Durée"),3,1);

        for (int i = 0; i < room.getReservationsOfWeek().size(); i++) {
            gridPane.add(new ReservationDisplay(room.getReservations().get(i)).getIdLbl(),0,i+2);
            gridPane.add(new ReservationDisplay(room.getReservations().get(i)).getStartDateLbl(),1,i+2);
            gridPane.add(new ReservationDisplay(room.getReservations().get(i)).getEndDateLbl(),2,i+2);
            gridPane.add(new ReservationDisplay(room.getReservations().get(i)).getDurationLbl(),3,i+2);
        }



        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.BOTTOM_CENTER);

        vBox.getChildren().addAll(nameRoom, capacity,gridPane);

        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(30,10,10,10));

        pane.getChildren().addAll(vBox);

        pane.setLayoutX(calculPosPopUp().getX());
        pane.setLayoutY(calculPosPopUp().getY());


        return pane;
    }

    private Point calculPosPopUp() {
        Point point = new Point();

        double sCX = Screen.getPrimary().getVisualBounds().getWidth() / 2;
        double sCY = Screen.getPrimary().getVisualBounds().getHeight() / 2;

        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;

        double maxY = -Double.MAX_VALUE;
        double maxX = -Double.MAX_VALUE;

        for (int i = 0; i < this.shape.getPoints().size(); i++) {
            if (i % 2 == 0) {
                if (this.shape.getPoints().get(i) > maxX) {
                    maxX = this.shape.getPoints().get(i);
                }
                if (this.shape.getPoints().get(i) < minX) {
                    minX = this.shape.getPoints().get(i);
                }
            } else {
                if (this.shape.getPoints().get(i) > maxY) {
                    maxY = this.shape.getPoints().get(i);
                }
                if (this.shape.getPoints().get(i) < minY) {
                    minY = this.shape.getPoints().get(i);
                }
            }
        }

        point.setLocation(maxX + sCX, maxY + sCY);

        return point;
    }

    private Point calculPosLabel() {
        Point point = new Point();

        double sCX = Screen.getPrimary().getVisualBounds().getWidth() / 2;
        double sCY = Screen.getPrimary().getVisualBounds().getHeight() / 2;

        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;

        double maxY = -Double.MAX_VALUE;
        double maxX = -Double.MAX_VALUE;

        for (int i = 0; i < this.shape.getPoints().size(); i++) {
            if (i % 2 == 0) {
                if (this.shape.getPoints().get(i) > maxX) {
                    maxX = this.shape.getPoints().get(i);
                }
                if (this.shape.getPoints().get(i) < minX) {
                    minX = this.shape.getPoints().get(i);
                }
            } else {
                if (this.shape.getPoints().get(i) > maxY) {
                    maxY = this.shape.getPoints().get(i);
                }
                if (this.shape.getPoints().get(i) < minY) {
                    minY = this.shape.getPoints().get(i);
                }
            }
        }

        point.setLocation(minX + Math.abs(Math.abs(maxX)-Math.abs(minX))/2 + sCX, minY + Math.abs(Math.abs(maxY)-Math.abs(minY))/2 +  sCY);

        return point;
    }

    public Color getColorRoom() {
        return colorRoom;
    }

    public void setHoverColor() throws Exception{
        Color currentColor = this.getColorRoom();

        if(currentColor == Color.WHITE){
            this.setColorRoom(Color.LIGHTGRAY);
        }
        else if(currentColor == Color.GREEN){
            this.setColorRoom(Color.DARKGREEN);
        }
        else if(currentColor == Color.ORANGE){
            this.setColorRoom(Color.DARKORANGE);
        }
        else if(currentColor == Color.RED){
            this.setColorRoom(Color.DARKRED);
        }
        else{
            throw new Exception("PROBLEME DE COULEUR");
        }

        this.shape.setFill(this.getColorRoom());
    }


    public void setUnHoverColor() throws Exception{
        Color currentColor = this.getColorRoom();

        if(currentColor == Color.LIGHTGRAY){
            this.setColorRoom(Color.WHITE);
        }
        else if(currentColor == Color.DARKGREEN){
            this.setColorRoom(Color.GREEN);
        }
        else if(currentColor == Color.DARKORANGE){
            this.setColorRoom(Color.ORANGE);
        }
        else if(currentColor == Color.DARKRED){
            this.setColorRoom(Color.RED);
        }
        else{
            throw new Exception("PROBLEME DE COULEUR");
        }

        this.shape.setFill(this.getColorRoom());
    }



    public void setRoomDisponibility() {

    }

    public double getX() {
        return this.coordinate.getX();
    }

    public double getY() {
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

    public Label getLabelNameRoomFix() {
        return labelNameRoomFix;
    }

    public void setNullDisplayPane() {
        this.displayPane = null;
    }

    public void setColorRoom(Color colorRoom) {
        this.colorRoom = colorRoom;
        this.shape.setFill(this.colorRoom);
    }

    public Room getRoom() {
        return room;
    }
}
