package fr.hexagone.front;

import fr.hexagone.model.Reservation;
import javafx.scene.control.Label;

/**
 * Decoupe les reservation en différentes information
 * pour les rendre plus facilement utilisables
 */
public class ReservationDisplay {

    private Reservation reservation;
    private Label idLbl;
    private Label startDateLbl;
    private Label endDateLbl;
    private Label durationLbl;

    /**
     * Initialise les différents Label avec les informations d'une réservation
     * @param reservation
     */

    public ReservationDisplay(Reservation reservation){
        this.reservation = reservation;
        this.idLbl = new Label(Integer.toString(this.reservation.getId()));
        this.startDateLbl = new Label(this.reservation.getStartDateTime().toString());
        this.endDateLbl = new Label(this.reservation.getEndDateTime().toString());
        this.durationLbl = new Label(convertEnumIntoDuration(this.reservation.getDuration()));
    }

    /**
     * Permet d'interpréter une énumération et d'en faire des chaines de charactères compréhensibles
     * @param number
     * @return
     */
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

    /**
     * Récupère le label relatif à l'ID
     * @return
     */
    public Label getIdLbl() {
        return idLbl;
    }

    /**
     * Récupère le label relatif à l'heure de début de la réservation
     * @return
     */
    public Label getStartDateLbl() {
        return startDateLbl;
    }

    /**
     * Récupère le label relatif à l'heure de fin de la réservation
     * @return
     */
    public Label getEndDateLbl() {
        return endDateLbl;
    }

    /**
     * Récupère le label relatif à la durée
     * @return
     */
    public Label getDurationLbl() {
        return durationLbl;
    }
}
