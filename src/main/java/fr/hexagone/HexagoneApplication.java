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

        /**
         * Créer l'object qui contiendra tous les autres objets graphiques
         */
        Pane mainPane = new Pane();
        /**
         * Permettra de lier les objets d'Hexagone Display au mainPane
         */
        HexagoneDisplay hexa = new HexagoneDisplay(mainPane);

        /**
         * Ajoute la forme de l'hexagone au principal objet mainPane
         */
        mainPane.getChildren().add(hexa.getForme());

        /**
         * Ajoute toutes les salles au mainPane
         */
        for(RoomDisplay roomDisp : hexa.getRoomDisplays()){
            mainPane.getChildren().add(roomDisp.getShape());
        }



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
