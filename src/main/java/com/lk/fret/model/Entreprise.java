package com.lk.fret.model;

import javafx.concurrent.Task;
import org.jspace.ActualField;
import org.jspace.Space;
import org.jspace.Tuple;

import java.security.SecureRandom;

public class Entreprise extends Task<Void> {

    private final int id;
    private final Space tupleSpaceMaterial;
    private Offre offre;
    private boolean sent = false;
    private String name;

    public Entreprise(Space spaceTuple, Offre offre, String name, int id) {
        this.tupleSpaceMaterial = spaceTuple;
        this.offre = offre;
        this.name = name;
        this.id = id;
    }

    public void ajoutOffre() throws InterruptedException {
        tupleSpaceMaterial.put("offre-" + id, offre);
        System.out.println(name + " " + id + ": ajoute une offre");
    }

    public int getId() {
        return id;
    }

    @Override
    protected void running() {
        super.running();
    }

    public String getName() {
        return name;
    }

    public Offre getOffre() {
        return offre;
    }

    @Override
    protected Void call() {
        try {
            while (!sent && tupleSpaceMaterial.queryp(new ActualField("appelOffreOuvert")) == null) {
                ajoutOffre();
                sent = true;
            }

            Object[] tuple = tupleSpaceMaterial.query(new ActualField("resultMeilleurOffre"));
            System.out.println("fin");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
