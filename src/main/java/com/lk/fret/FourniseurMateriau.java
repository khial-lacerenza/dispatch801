package com.lk.fret;

import org.jspace.Space;

import java.util.Date;

public class FourniseurMateriau implements Runnable {

    private Space tupleSpaceMaterial;
    private OffreMateriel offreMateriel;

    public FourniseurMateriau(Space tupleSpaceMaterial) {
        this.tupleSpaceMaterial = tupleSpaceMaterial;
        this.offreMateriel = new OffreMateriel();
    }

    @Override
    public void run() {

    }
}
