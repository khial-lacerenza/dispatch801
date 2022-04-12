package com.lk.fret;

import com.lk.fret.Model.Offre;
import com.lk.fret.Model.Produit;

import java.security.SecureRandom;

public class OffreMateriel extends Offre {

    private Produit produit;

    public OffreMateriel() {
        super(new int[]{5, 20}, new int[]{10, 370}, new int[]{1, 5});
        this.produit = Produit.values()[new SecureRandom().nextInt(Produit.values().length)];
    }

    public Produit getProduit() {
        return produit;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "quantite=" + getQuantite() +
                ", duree=" + getDuree() +
                ", prix=" + getPrix() +
                ", produit=" + produit +
                '}';
    }
}
