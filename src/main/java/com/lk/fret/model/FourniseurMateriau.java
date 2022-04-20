package com.lk.fret.model;

import org.jspace.Space;

public class FourniseurMateriau extends Entreprise {
    private Space tupleSpaceTransport;

    public FourniseurMateriau(Space tupleSpaceMaterial) {
        super(tupleSpaceMaterial, new OffreMateriel(), "FournisseurMateriau");
    }
}
