package com.lk.fret;

import java.util.Date;

public class OffreMateriel {
    private int quantite, prix;
    private String produit;
    private Date date;

    public OffreMateriel(int quantite, int prix, String produit, Date date) {
        this.quantite = quantite;
        this.prix = prix;
        this.produit = produit;
        this.date = date;
    }
}
