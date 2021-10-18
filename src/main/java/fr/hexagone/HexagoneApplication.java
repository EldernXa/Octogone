package fr.hexagone;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
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
        Scene scene = new Scene(new VBox(), 800, 600);
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
