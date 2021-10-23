package fr.hexagone.front;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Form extends GridPane {

    private final DatePicker datePicker;
    private ComboBox<String> seatsComboBox;
    private ComboBox<String> hourComboBox;
    private LocalDateTime localDateTime;



    public Form() {
        this.datePicker = new DatePicker(LocalDate.now());
        datePicker.setShowWeekNumbers(false);

        comboBoxInit();

        this.add(new Label("Date "),0,0);
        this.add(new Label("Heure "),0,1);
        this.add(new Label("Places "),0,2);

        this.add(datePicker,1,0);
        this.add(hourComboBox,1,1);
        this.add(seatsComboBox,1,2);
        this.add(validateButton(),0,3);


        this.setPadding(new Insets(10));
        this.setVgap(10);



    }


    public Button validateButton() {


        Button button = new Button("Valider");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                datePicker.setValue(datePicker.getConverter()
                        .fromString(datePicker.getEditor().getText()));

                String hour = hourComboBox.getValue();
                String[] hourAndMinuts = hour.split(":");

                localDateTime = LocalDateTime.of(datePicker.getValue().getYear(), datePicker.getValue().getMonth(),
                        datePicker.getValue().getDayOfMonth(), Integer.parseInt(hourAndMinuts[0]), Integer.parseInt(hourAndMinuts[1]));


            }
        });

        return button;

    }

    public void comboBoxInit() {
        ObservableList<String> seats =
                FXCollections.observableArrayList(
                        "1",
                        "2",
                        "3",
                        "4",
                        "5",
                        "6"
                );


        ObservableList<String> hour =
                FXCollections.observableArrayList(
                        "8:00",
                        "8:30",
                        "9:00",
                        "10:00",
                        "10:30",
                        "11:00",
                        "11:30",
                        "12:00",
                        "12:30",
                        "13:00",
                        "13:30",
                        "14:00",
                        "14:30",
                        "15:00",
                        "15:30",
                        "16:00",
                        "16:30",
                        "17:00",
                        "17:30",
                        "18:00",
                        "18:30",
                        "19:00"
                );

        Label label = new Label("Heure");
        seatsComboBox = new ComboBox<>(seats);
        seatsComboBox.getSelectionModel().selectFirst();
        hourComboBox = new ComboBox<>(hour);
        hourComboBox.getSelectionModel().selectFirst();



    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
