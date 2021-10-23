package fr.hexagone;

import fr.hexagone.front.HexagoneDisplay;
import fr.hexagone.front.RoomDisplay;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HexagoneApplication extends Application {

    private ConfigurableApplicationContext springContext;

    @Override
    public void init() throws Exception{
        springContext = SpringApplication.run(HexagoneApplication.class);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Héxagone réservation");
        primaryStage.setMaximized(true);

        HexagoneDisplay hexa = new HexagoneDisplay();

        Pane mainPane = new Pane();
        mainPane.getChildren().add(hexa.getForme());

        for(RoomDisplay romDisp : hexa.getSallesAffichages()){
            mainPane.getChildren().add(romDisp.getShape());
        }

        mainPane.getChildren().add(hexa.getPane());

        Scene scene = new Scene(mainPane, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception{
        springContext.stop();
    }

    public static void main(String[] args){
        launch(HexagoneApplication.class, args);
    }

}
