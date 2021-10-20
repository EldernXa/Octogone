package fr.hexagone.front;

import fr.hexagone.back.Salle;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

public class SalleAffichage {

    private Coordonnee coordonnee;
    private Path forme;
    private Label nomSalle;
    private Color couleurSalle;

    public SalleAffichage(Coordonnee coordonnee, Path forme, Label nomSalle, Color couleurSalle){
        this.coordonnee = coordonnee;
        this.forme = forme;
        this.nomSalle = nomSalle;
        this.couleurSalle = couleurSalle;
    }
}
