package com.lk.fret;

import com.lk.fret.Model.Entreprise;
import org.jspace.Space;

public class FourniseurMateriau extends Entreprise {
        private Space tupleSpaceTransport;

    public FourniseurMateriau(Space tupleSpaceMaterial) {
        super(tupleSpaceMaterial, new OffreMateriel(), "FournisseurMateriau");
    }
}
