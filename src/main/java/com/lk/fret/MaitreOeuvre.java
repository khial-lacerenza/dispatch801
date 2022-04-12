package com.lk.fret;

import org.jspace.ActualField;
import org.jspace.Space;
import org.jspace.Tuple;

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

    public void recupOffreMateriel()
    {

    }
}
