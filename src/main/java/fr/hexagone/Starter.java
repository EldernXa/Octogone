package fr.hexagone;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = Starter.class)
public class Starter {

    public static void main(String[] args){
        HexagoneApplication.main(args);
    }

}
