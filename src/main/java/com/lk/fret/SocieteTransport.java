package com.lk.fret;

import com.lk.fret.Model.Entreprise;
import org.jspace.Space;

public class SocieteTransport extends Entreprise {
    private Space tupleSpaceTransport;

    public SocieteTransport(Space tupleSpaceTransport) {
        super(tupleSpaceTransport, new OffreTransport(), "SocieteTransport");
    }
}
