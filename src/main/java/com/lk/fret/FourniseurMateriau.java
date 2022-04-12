package com.lk.fret;

import org.jspace.Space;

public class FourniseurMateriau {

    private Space tupleSpaceMaterial;

    public FourniseurMateriau(Space tupleSpaceMaterial) {
        this.tupleSpaceMaterial = tupleSpaceMaterial;
    }

    public void offreMateriel(String type, int quantite) throws InterruptedException {
        tupleSpaceMaterial.put(type, quantite);
    }
}
