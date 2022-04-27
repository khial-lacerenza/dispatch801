package com.lk.fret.model;

import org.jspace.Space;

public class FourniseurMateriau extends Entreprise {

    private static int ID = 1;
    private Space tupleSpaceTransport;

    public FourniseurMateriau(Space tupleSpaceMaterial) {
        super(tupleSpaceMaterial, new OffreMateriel(), "FournisseurMateriau", ID++);
    }
}
