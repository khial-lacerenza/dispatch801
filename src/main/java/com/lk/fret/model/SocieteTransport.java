package com.lk.fret.model;

import org.jspace.Space;

public class SocieteTransport extends Entreprise {
    private static int ID = 1;
    private Space tupleSpaceTransport;

    public SocieteTransport(Space tupleSpaceTransport) {
        super(tupleSpaceTransport, new OffreTransport(), "SocieteTransport", ID++);
    }
}
