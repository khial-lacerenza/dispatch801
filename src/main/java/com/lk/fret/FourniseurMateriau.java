package com.lk.fret;

import org.jspace.Space;

import java.util.Date;

public class FourniseurMateriau implements Runnable {

    private Space tupleSpaceMaterial;


    public FourniseurMateriau(Space tupleSpaceMaterial) {
        this.tupleSpaceMaterial = tupleSpaceMaterial;
    }

    public void offreMateriel(String type, int quantite) throws InterruptedException {
        tupleSpaceMaterial.put(type, quantite);
    }

    @Override
    public void run() {

    }
}
