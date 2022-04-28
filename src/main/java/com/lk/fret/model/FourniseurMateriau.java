package com.lk.fret.model;

import com.jfoenix.controls.JFXListView;
import org.jspace.Space;

public class FourniseurMateriau extends Entreprise {

    private static int ID = 1;
    private Space tupleSpaceTransport;
    JFXListView<String> materiaux;
    JFXListView<String> maitreOeuvreList;

    public FourniseurMateriau(Space tupleSpaceMaterial, JFXListView<String> materiauList) {
        super(tupleSpaceMaterial, new OffreMateriel(), "FournisseurMateriau", ID);
        materiauList.getItems().add("Fournisseur de Materiau - " + ID);
        ID++;
    }
    public FourniseurMateriau(Space tupleSpaceMaterial, JFXListView<String> materiauxList, JFXListView<String> materiauxOffreList, JFXListView<String> maitreOeuvreList) {
        super(tupleSpaceMaterial, new OffreMateriel(), "FournisseurMateriau", ID);
        materiauxList.getItems().add("Fournisseur de Materiau - " + ID);
        this.materiaux = materiauxOffreList;
        this.maitreOeuvreList = maitreOeuvreList;
        ID++;
    }

    @Override
    public boolean verifMeilleurOffre() throws InterruptedException {
        if(super.verifMeilleurOffre()) {
            maitreOeuvreList.getItems().add("Materiel : " + getId() + " : " + getOffre());
        }

        return super.verifMeilleurOffre();
    }

    @Override
    public void ajoutOffre() throws InterruptedException {
        super.ajoutOffre();
        materiaux.getItems().add(getId() + " : " + getOffre());
    }
}
