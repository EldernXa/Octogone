package fr.hexagone.front;

import fr.hexagone.model.Reservation;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ReservationDisplay {

    private Reservation reservation;

    public ReservationDisplay(Reservation reservation){
        this.reservation = reservation;
    }

    public Pane createReservationDisplay(){
        GridPane reservationPane = new GridPane();
        reservationPane.add(new Label(Integer.toString(reservation.getId())),0,0);
        reservationPane.add(new Label(reservation.getStartDateTime().toString()),1,0);
        reservationPane.add(new Label(reservation.getEndDateTime().toString()),2,0);
        reservationPane.add(new Label(Integer.toString(reservation.getDuration())),3,0);
        return reservationPane;
    }
}
