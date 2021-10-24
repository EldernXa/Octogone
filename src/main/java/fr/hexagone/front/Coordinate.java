package fr.hexagone.front;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represente les coordonnées d'une entité graphique
 */
public @AllArgsConstructor @Data
class Coordinate {
    private double x;
    private double y;
}
