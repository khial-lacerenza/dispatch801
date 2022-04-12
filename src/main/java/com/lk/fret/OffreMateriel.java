package com.lk.fret;

import java.util.Random;

public class OffreMateriel {

    // generate random numbers between n range
    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }

    private int quantite, prix;
    private String produit;
    private int nbMois;

    public OffreMateriel() {
        this.quantite = getRandomNumber(5, 20); // en miller d'unités
        this.prix = getRandomNumber(10,370);   // en millier d'euros
        this.produit = "Chaussettes";
        this.nbMois = getRandomNumber(1,5);
    }

    public int getQuantite() {
        return quantite;
    }

    public int getPrix() {
        return prix;
    }

    public String getProduit() {
        return produit;
    }

    public int getNbMois() {
        return nbMois;
    }
}
