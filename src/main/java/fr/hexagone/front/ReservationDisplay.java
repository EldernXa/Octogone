package fr.hexagone.front;

import fr.hexagone.model.Reservation;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ReservationDisplay {

    private Reservation reservation;
    private Label idLbl;
    private Label startDateLbl;
    private Label endDateLbl;
    private Label durationLbl;

    public ReservationDisplay(Reservation reservation){
        this.reservation = reservation;
        this.idLbl = new Label(Integer.toString(this.reservation.getId()));
        this.startDateLbl = new Label(this.reservation.getStartDateTime().toString());
        this.endDateLbl = new Label(this.reservation.getEndDateTime().toString());
        this.durationLbl = new Label(convertEnumIntoDuration(this.reservation.getDuration()));
    }

    private String convertEnumIntoDuration(int number){
        switch (number){
            case 1:
                return "30 min";
            case 2:
                return "1h";
            case 3:
                return "1h30";
            case 4:
                return "2h";
            case 5:
                return "2h30";
            case 6:
                return "3h";
        }
        return "";
    }

    public Label getIdLbl() {
        return idLbl;
    }

    public Label getStartDateLbl() {
        return startDateLbl;
    }

    public Label getEndDateLbl() {
        return endDateLbl;
    }

    public Label getDurationLbl() {
        return durationLbl;
    }
}
