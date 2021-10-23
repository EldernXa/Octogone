package fr.hexagone.front;

import fr.hexagone.back.BookRoomResult;
import fr.hexagone.back.RoomController;
import fr.hexagone.model.Room;
import fr.hexagone.utility.BeanUtil;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.time.LocalDateTime;

public class ReservationForm extends GridPane {

    private String mail;
    private Button validateButton;
    private TextField textField;
    private Room room;
    private LocalDateTime localDateTime;
    private int duration;
    private Stage stage;
    private Label labelErr;


    public ReservationForm(Room room, LocalDateTime localDateTime, int duration) {
        this.setMinSize(300,300);

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

    public void closeRequest(EventHandler<WindowEvent> eventHandler){
        stage.setOnCloseRequest(eventHandler);
    }

    public void mailForm(){

        textField = new TextField();
        this.add(new Label("Mail"),0,0);
        this.add(textField,1,0);

    }


    public void validateButton(){


        validateButton = new Button("Valider");
        this.add(validateButton,0,6);
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

    public  void displayData(){


        this.add(new Label("Salle "),0,1);
        this.add(new Label("Equipements "),0,2);
        this.add(new Label("Date "),0,3);
        this.add(new Label("Durée "),0,4);
        this.add(new Label("Places "),0,5);

        StringBuilder features = new StringBuilder("");
        for (String string : room.getFeatures()){

            features.append(string).append(", ");
        }
        features.deleteCharAt(features.length()-2);
        this.add(new Label(room.getName()),1,1);
        this.add(new Label(features.toString()),1,2);
        this.add(new Label(localDateTime.toString()),1,3);
        this.add(new Label(String.valueOf(duration)),1,4);
        this.add(new Label(String.valueOf(room.getCapacity())),1,5);
    }


    public void close(){
        stage.close();
    }

    public boolean control(){
        RoomController roomController = BeanUtil.getBean(RoomController.class);
        BookRoomResult bookRoomResult = roomController.bookRoom(room.getId(),mail,localDateTime,duration);

        switch (bookRoomResult){
            case OK:
                labelErr.setText("OK");
                return true;
            case INVALID_END_DATETIME:
                labelErr.setText("INVALID_END_DATETIME");
                break;
            case INVALID_DURATION:
                labelErr.setText("INVALID_DURATION");
                break;
            case INVALID_ROOM:
                labelErr.setText("INVALID_ROOM");
                break;
            case ROOM_NOT_AVAILABLE:
                labelErr.setText("ROOM_NOT_AVAILABLE");
                break;
            case PERSISTANCE_ERROR:
                labelErr.setText("PERSISTANCE_ERROR");
                break;
            case INVALID_MAIL:
                labelErr.setText("INVALID_MAIL");
                break;
        }

        return false;

    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hexagone");
        alert.setHeaderText("Réservation confirmée à " + localDateTime.getHour() + ":" + localDateTime.getMinute() + " le "
                + localDateTime.getDayOfMonth() +"/"+localDateTime.getMonthValue()+"/"+localDateTime.getYear() +" dans la salle " + room.getName());

        alert.showAndWait();
    }
}
