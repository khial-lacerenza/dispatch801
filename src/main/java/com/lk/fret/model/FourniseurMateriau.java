package com.lk.fret.model;

import com.jfoenix.controls.JFXListView;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import org.jspace.Space;

import java.security.SecureRandom;

public class FourniseurMateriau extends Entreprise {

    private static int ID = 1;
    private Space tupleSpaceTransport;
    JFXListView<String> materiaux;

    public FourniseurMateriau(Space tupleSpaceMaterial, JFXListView<String> materiauList) {
        super(tupleSpaceMaterial, new OffreMateriel(), "FournisseurMateriau", ID);
        materiauList.getItems().add("Fournisseur de Materiau - " + ID);
        ID++;
    }
    public FourniseurMateriau(Space tupleSpaceMaterial, JFXListView<String> materiauxList, JFXListView<String> materiauxOffreList) {
        super(tupleSpaceMaterial, new OffreMateriel(), "FournisseurMateriau", ID);
        materiauxList.getItems().add("Fournisseur de Materiau - " + ID);
        this.materiaux = materiauxOffreList;
        ID++;
    }

    @Override
    public void ajoutOffre() throws InterruptedException {
        super.ajoutOffre();
        SecureRandom random = new SecureRandom();
        int randomInt = random.nextInt(3);
        materiaux.getItems().add(getId() + " : " + getOffre());
    }
}
