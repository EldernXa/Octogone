package fr.hexagone;

import fr.hexagone.front.HexagoneAffichage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.geom.Point2D;

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

        HexagoneAffichage hexa = new HexagoneAffichage();

        Pane pane = new Pane();
        pane.getChildren().add(hexa.getForme());
        pane.getChildren().add(hexa.getSalle1());
        pane.getChildren().add(hexa.getSalle2());
        pane.getChildren().add(hexa.getSalle3());

        Scene scene = new Scene(pane, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());

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
