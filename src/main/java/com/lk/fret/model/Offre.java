package com.lk.fret.model;

import java.util.Random;

public class Offre {


    // generate random numbers between n range
    public int getRandomNumber(int[] range) {
        Random random = new Random();
        return random.ints(range[0], range[1]).findFirst().getAsInt();
    }

    private int quantite, duree, prix;

    public Offre(int[] quantite, int prix[], int duree[]) {
        this.quantite = getRandomNumber(quantite); // en miller d'unités
        this.prix = getRandomNumber(prix);   // en millier d'euros
        this.duree = getRandomNumber(duree);
    }

    public int getQuantite() {
        return quantite;
    }

    public int getPrix() {
        return prix;
    }

    public int getDuree() {
        return duree;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "quantite=" + quantite +
                ", duree=" + duree +
                ", prix=" + prix +
                '}';
    }
}
