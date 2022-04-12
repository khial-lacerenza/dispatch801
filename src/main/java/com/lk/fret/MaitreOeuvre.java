package com.lk.fret;

import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.Space;
import org.jspace.Tuple;

import java.util.List;

public class MaitreOeuvre {


    private Space tupleSpaceMaterial;
    private Space tupleSpaceTransport;

    public MaitreOeuvre(Space tupleSpaceMaterial, Space tupleSpaceTransport) {
        this.tupleSpaceMaterial = tupleSpaceMaterial;
        this.tupleSpaceTransport = tupleSpaceTransport;
    }


    public void appelOffreMateriel(String type, int quantite) throws InterruptedException {
        Tuple tuple = new Tuple(type, quantite);
        tupleSpaceMaterial.put(tuple);
    }

    public void appelOffreTransport(String type, int quantite) throws InterruptedException {
        Tuple tuple = new Tuple(type, quantite);
        tupleSpaceTransport.put(tuple);
    }

    public void debutAppeldOffreMateriel() throws InterruptedException {
        Tuple tuple = new Tuple("appelOffreMaterielOuvert");
        tupleSpaceMaterial.put(tuple);
    }

    public void debutAppeldOffreTransport() throws InterruptedException {
        Tuple tuple = new Tuple("appelOffreTransportOuvert");
        tupleSpaceTransport.put(tuple);
    }

    public void recupOffreMateriel() throws InterruptedException {
        tupleSpaceMaterial.put(new ActualField("appelOffreMaterielOuvert"));

        boolean isEmpty = false;
        Object[] offre = tupleSpaceMaterial.getp(new FormalField(String.class), new FormalField(OffreMateriel.class));
        System.out.println(offre);
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
        tupleSpaceMaterial.put(new ActualField("appelOffreTransportOuvert"));

        boolean isEmpty = false;
        Object[] offre = tupleSpaceTransport.getp(new FormalField(String.class), new FormalField(OffreTransport.class));
        System.out.println(offre);
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
