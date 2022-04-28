package com.lk.fret.model;

import javafx.concurrent.Task;
import org.jspace.ActualField;
import org.jspace.Space;

public class Entreprise extends Task<Void> {

    private final int id;
    private final Space tupleSpace;
    private Offre offre;
    private boolean sent = false;
    private String name;

    public Entreprise(Space spaceTuple, Offre offre, String name, int id) {
        this.tupleSpace = spaceTuple;
        this.offre = offre;
        this.name = name;
        this.id = id;
    }

    public void ajoutOffre() throws InterruptedException {
        tupleSpace.put("offre-" + id, offre);
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
            tupleSpace.query(new ActualField("appelOffreOuvert"));
            ajoutOffre();

            tupleSpace.query(new ActualField("resultatMeilleurOffre"));
            System.out.println("fin");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
