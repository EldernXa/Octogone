package fr.hexagone.front;

import fr.hexagone.back.BookRoomResult;
import fr.hexagone.back.RoomController;
import fr.hexagone.model.Room;
import fr.hexagone.utility.BeanUtil;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class ReservationForm extends GridPane {

    private String mail;
    private TextField textField;
    private final Room room;
    private final LocalDateTime localDateTime;
    private final int duration;
    private final Stage stage;
    private final Label labelErr;


    public ReservationForm(Room room, LocalDateTime localDateTime, int duration) {
        this.setMinSize(500,300);

        this.room = room;
        this.localDateTime = localDateTime;
        this.duration = duration;
        this.labelErr = new Label();

        mailForm();
        displayData();
        validateButton();


        this.setPadding(new Insets(10));
        this.setVgap(10);
        this.setHgap(3);
        stage = new Stage();
        stage.setScene(new Scene(this));
        stage.show();
    }

    /**
     * Crée le textField et le label pour renter le mail
     */
    public void mailForm(){

        textField = new TextField();
        this.add(new Label("Mail"),0,0);
        this.add(textField,1,0);

    }

    /**
     *Crée un bouton de validation.
     *Ce bouton récupère les valeurs du textField et ferme la fenêtre en affichant un message de confirmation
     */
    public void validateButton(){


        Button validateButton = new Button("Valider");
        this.add(validateButton,0,7);
        validateButton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    this.mail = textField.getText();
                    if(control()){
                     close();
                     showAlert();
                    }
                });


        this.add(labelErr,3,0);
    }

    /**
     * Place les différents objets et labels de l'interface dans le GridPane
     */
    public  void displayData(){

        String durationDisplay ="";
        switch (duration) {
            case 1:
                durationDisplay = "30min";
                break;
            case 2:
                durationDisplay = "1h";
                break;
            case 3:
                durationDisplay = "1h30";
                break;
            case 4:
                durationDisplay = "2h";
                break;
            case 5:
                durationDisplay = "2h30";
                break;
            case 6:
                durationDisplay = "3h";
                break;

        }

        this.add(new Label("Salle "),0,1);
        this.add(new Label("Equipements "),0,2);
        this.add(new Label("Date "),0,3);
        this.add(new Label("Heure "),0,4);
        this.add(new Label("Durée "),0,5);
        this.add(new Label("Places "),0,6);

        StringBuilder features = new StringBuilder();
        for (String string : room.getFeatures()){

            features.append(string).append(", ");
        }
        features.deleteCharAt(features.length()-2);
        this.add(new Label(room.getName()),1,1);
        this.add(new Label(features.toString()),1,2);
        this.add(new Label(localDateTime.getDayOfMonth() +"/"+localDateTime.getMonthValue()+"/"+localDateTime.getYear()),1,3);
        this.add(new Label(localDateTime.getHour() +":"+goodHourFormat()),1,4);
        this.add(new Label(durationDisplay),1,5);
        this.add(new Label(String.valueOf(room.getCapacity())),1,6);
    }

    /**
     * Ferme la fenêtre de réservation
     */
    public void close(){
        stage.close();
    }

    /**
     * Réserve la salle et gère le erreurs
     * @return vrai si il n'y a pas d'erreur et faux si une des conditions est invalide
     */
    public boolean control(){
        RoomController roomController = BeanUtil.getBean(RoomController.class);
        BookRoomResult bookRoomResult = roomController.bookRoom(room.getId(),mail,localDateTime,duration);

        switch (bookRoomResult){
            case OK:
                labelErr.setText("OK");
                return true;
            case INVALID_END_DATETIME:
                labelErr.setText("La date de fin ne peut pas être \ndans le passé.");
                break;
            case INVALID_DURATION:
                labelErr.setText("Durée invalide.");
                break;
            case INVALID_ROOM:
                labelErr.setText("Salle inexistante");
                break;
            case ROOM_NOT_AVAILABLE:
                labelErr.setText("Salle déjà réservée sur ce créneau");
                break;
            case PERSISTANCE_ERROR:
                labelErr.setText("Données invalides");
                break;
            case INVALID_MAIL:
                labelErr.setText("Seul les mails universitaires sont autorisés");
                break;
        }

        return false;

    }

    /**
     * Crée une alerte qui affiche les données de la reservation une fois qu'elle est confirmée
     */
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hexagone");
        alert.setHeaderText("Réservation confirmée à  " + localDateTime.getHour() + ":" + goodHourFormat() + " le "
                + localDateTime.getDayOfMonth() +"/"+localDateTime.getMonthValue()+"/"+localDateTime.getYear() +" dans la salle " + room.getName());

        alert.showAndWait();
    }


    /**
     * Renvoit un string pour avoir un affichage des minutes plus esththétique
     * @return
     */
    public String goodHourFormat(){

        if( localDateTime.getMinute() == 0){
            return "00";
        }
        return String.valueOf(localDateTime.getMinute());
    }
}
