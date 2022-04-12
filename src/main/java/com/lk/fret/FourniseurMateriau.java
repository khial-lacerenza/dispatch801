package com.lk.fret;

import org.jspace.Space;

public class FourniseurMateriau implements Runnable {

    private static int ID = 0;
    private final int id;
    private final Space tupleSpaceMaterial;
    private OffreMateriel offreMateriel;

    public FourniseurMateriau(Space tupleSpaceMaterial) {
        this.id = ID++;
        this.tupleSpaceMaterial = tupleSpaceMaterial;
        this.offreMateriel = new OffreMateriel();
    }

    public void ajoutOffre() throws InterruptedException {
        tupleSpaceMaterial.put("offre-" + id, offreMateriel);
    }

    @Override
    public void run() {

    }
}
