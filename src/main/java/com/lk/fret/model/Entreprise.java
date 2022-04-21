package com.lk.fret.model;

import javafx.concurrent.Task;
import org.jspace.ActualField;
import org.jspace.Space;

public class Entreprise extends Task<Void> {

    private static int ID = 1;
    private final int id;
    private final Space tupleSpaceMaterial;
    private Offre offre;
    private boolean sent = false;
    private String name;

    public Entreprise(Space spaceTuple, Offre offre, String name) {
        this.id = ID++;
        this.tupleSpaceMaterial = spaceTuple;
        this.offre = offre;
        this.name = name;
    }

    public void ajoutOffre() throws InterruptedException {
        tupleSpaceMaterial.put("offre-" + id, offre);
        System.out.println(name + " " + id + ": ajoute une offre");
    }

    @Override
    protected Void call() throws Exception {
        try {
            while (!sent && tupleSpaceMaterial.queryp(new ActualField("appelOffreOuvert")) == null) {
                ajoutOffre();
                sent = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
