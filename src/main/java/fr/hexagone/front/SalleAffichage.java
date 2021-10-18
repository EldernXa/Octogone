package fr.hexagone.front;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

public class SalleAffichage {

    private Coordinate coordonnee;
    private Path forme;
    private Label nomSalle;
    private Color couleurSalle;

    public SalleAffichage(Coordinate coordonnee, Path forme, Label nomSalle, Color couleurSalle){
        this.coordonnee = coordonnee;
        this.forme = forme;
        this.nomSalle = nomSalle;
        this.couleurSalle = couleurSalle;

        this.forme.setLayoutX(this.coordonnee.);
    }
}
