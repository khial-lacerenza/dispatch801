package com.lk.fret;

import org.jspace.Space;

public class SocieteTransport {

    private Space tupleSpaceTransport;

    public SocieteTransport(Space tupleSpaceTransport) {
        this.tupleSpaceTransport = tupleSpaceTransport;
    }

    public void offreTransport(String type, int quantite) throws InterruptedException {
        tupleSpaceTransport.put(type, quantite);
    }
}
