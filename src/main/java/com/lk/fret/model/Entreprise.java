package com.lk.fret.model;

import javafx.concurrent.Task;
import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.Space;

import java.security.SecureRandom;

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

    public boolean verifMeilleurOffre() throws InterruptedException {
       Object[] tuple = tupleSpace.query(new ActualField("resultatMeilleurOffre"), new FormalField(Integer.class));
       if ((int) tuple[1] == id) {
           System.out.println("Moi thread n°" +id+ " j'ai gagné l'appel d'offre");
           return true;
       }else {
           System.out.println("Moi thread n°" +id+ " j'ai perdu l'appel d'offre");
           return false;
       }
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
            try {
                Thread.sleep(new SecureRandom().nextInt(3000) + 1000);
                tupleSpace.query(new ActualField("appelOffreOuvert"));
                ajoutOffre();
            } catch (InterruptedException ignored) {
                throw new RuntimeException(ignored);
            }
            verifMeilleurOffre();
        } catch (InterruptedException ignored) {
            throw new RuntimeException(ignored);
        }
        return null;
    }
}
