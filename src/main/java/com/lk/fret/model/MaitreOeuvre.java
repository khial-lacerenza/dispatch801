package com.lk.fret.model;

import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.Space;
import org.jspace.Tuple;

public class MaitreOeuvre {


    private Space tupleSpaceMaterial;
    private Space tupleSpaceTransport;

    public MaitreOeuvre(Space tupleSpaceMaterial, Space tupleSpaceTransport) {
        this.tupleSpaceMaterial = tupleSpaceMaterial;
        this.tupleSpaceTransport = tupleSpaceTransport;
    }

    public void debutAppeldOffreMateriel() throws InterruptedException {
        Tuple tuple = new Tuple("appelOffreOuvert");
        tupleSpaceMaterial.put(tuple);
    }

    public void debutAppeldOffreTransport() throws InterruptedException {
        Tuple tuple = new Tuple("appelOffreOuvert");
        tupleSpaceTransport.put(tuple);
    }

    public void recupOffreMateriel() throws InterruptedException {
        tupleSpaceMaterial.put(new ActualField("appelOffreOuvert"));

        boolean isEmpty = false;
        Object[] offre = tupleSpaceMaterial.getp(new FormalField(String.class), new FormalField(OffreMateriel.class));
        while (!isEmpty) {
            if(offre == null) {
                isEmpty = true;
            } else {
                System.out.println("Offre materiel  : " + offre[0] + " " + offre[1]);
            }
            offre = tupleSpaceMaterial.getp(new FormalField(String.class), new FormalField(OffreMateriel.class));
        }
    }

    public void recupOffreTransport() throws InterruptedException {
        tupleSpaceMaterial.put(new ActualField("appelOffreOuvert"));

        boolean isEmpty = false;
        Object[] offre = tupleSpaceTransport.getp(new FormalField(String.class), new FormalField(OffreTransport.class));
        while (!isEmpty) {
            if (offre == null) {
                isEmpty = true;
            } else {
                System.out.println("Offre transport  : " + offre[0] + " " + offre[1]);
            }
            offre = tupleSpaceTransport.getp(new FormalField(String.class), new FormalField(OffreTransport.class));
        }
    }
}
