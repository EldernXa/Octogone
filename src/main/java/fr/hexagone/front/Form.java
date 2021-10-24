package fr.hexagone.front;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Form extends GridPane {

    private final DatePicker datePicker;
    private ComboBox<String> seatsComboBox;
    private ComboBox<String> hourComboBox;
    private ComboBox<String> timeComboBox;
    private LocalDateTime localDateTime;
    private int seats;
    private int duration;
    private final Button button;



    public Form() {
        this.datePicker = new DatePicker(LocalDate.now());
        datePicker.setShowWeekNumbers(false);
        button = new Button("Valider");
        comboBoxInit();


        this.add(new Label("Date "),0,0);
        this.add(new Label("Heure "),0,1);
        this.add(new Label("Durée "),0,2);
        this.add(new Label("Places "),0,3);

        this.add(datePicker,1,0);
        this.add(hourComboBox,1,1);
        this.add(timeComboBox,1,2);
        this.add(seatsComboBox,1,3);
        this.add(validateButton(),0,4);


        this.setPadding(new Insets(10));
        this.setVgap(10);



    }


    public Button validateButton() {




        button.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    datePicker.setValue(datePicker.getConverter()
                            .fromString(datePicker.getEditor().getText()));

                    String hour = hourComboBox.getValue();
                    String[] hourAndMinuts = hour.split(":");
                    seats = Integer.parseInt(seatsComboBox.getValue());


                    switch (timeComboBox.getValue()){
                        case "30min":
                            duration =1;
                            break;
                        case "1h":
                            duration =2;
                            break;
                        case "1h30":
                            duration =3;
                            break;
                        case "2h":
                            duration =4;
                            break;
                        case "2h30":
                            duration =5;
                            break;
                        case "3h":
                            duration =6;
                            break;



                    }
                    localDateTime = LocalDateTime.of(datePicker.getValue().getYear(), datePicker.getValue().getMonth(),
                            datePicker.getValue().getDayOfMonth(), Integer.parseInt(hourAndMinuts[0]), Integer.parseInt(hourAndMinuts[1]));




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
                        "6",
                        "7",
                        "8"
                );


        ObservableList<String> hour =
                FXCollections.observableArrayList(
                        "8:00",
                        "8:30",
                        "9:00",
                        "9:30",
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
        ObservableList<String> duration =
                FXCollections.observableArrayList(
                        "30min",
                        "1h",
                        "1h30",
                        "2h",
                        "2h30",
                        "3h"

                );



        seatsComboBox = new ComboBox<>(seats);
        seatsComboBox.getSelectionModel().selectFirst();
        hourComboBox = new ComboBox<>(hour);
        hourComboBox.getSelectionModel().selectFirst();
        timeComboBox = new ComboBox<>(duration);
        timeComboBox.getSelectionModel().selectFirst();



    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public int getSeats() {
        return seats;
    }

    public int getDuration() {
        return duration;
    }

    public Button getButton() {
        return button;
    }
}
