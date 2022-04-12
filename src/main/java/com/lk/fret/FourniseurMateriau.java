package com.lk.fret;

import org.jspace.ActualField;
import org.jspace.Space;

public class FourniseurMateriau implements Runnable {

    private static int ID = 1;
    private final int id;
    private final Space tupleSpaceMaterial;
    private OffreMateriel offreMateriel;
    private boolean sent = false;

    public FourniseurMateriau(Space tupleSpaceMaterial) {
        this.id = ID++;
        this.tupleSpaceMaterial = tupleSpaceMaterial;
        this.offreMateriel = new OffreMateriel();
    }

    public void ajoutOffre() throws InterruptedException {
        tupleSpaceMaterial.put("offre-" + id, offreMateriel);
        System.out.println("Fournisseur " + id + " ajoute une offre");
    }

    @Override
    public void run() {
        try {
            while (!sent && tupleSpaceMaterial.queryp(new ActualField("appelOffreMaterielOuvert")) != null) {
                ajoutOffre();
                sent = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
