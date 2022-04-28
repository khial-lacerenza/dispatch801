package com.lk.fret.model;

import com.jfoenix.controls.JFXListView;
import org.jspace.Space;

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
        materiaux.getItems().add(getId() + " : " + getOffre());
    }
}
