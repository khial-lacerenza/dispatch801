package com.lk.fret;

import java.util.Date;
import java.util.Random;

public class OffreTransport {
    private int quantite, duree, prix;

    public int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

    public OffreTransport() {
        //Nombre de conteneur
        this.quantite = getRandomNumberUsingInts(5,20);
        //Prix en millier d'euros
        this.prix = getRandomNumberUsingInts(100,500);
        //Durée du transport en jours
        this.duree = getRandomNumberUsingInts(3,18);
    }

    public int getQuantite() {
        return quantite;
    }

    public int getDuree() {
        return duree;
    }

    public int getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "OffreTransport{" +
                "quantite=" + quantite +
                ", duree=" + duree +
                ", prix=" + prix +
                '}';
    }
}
