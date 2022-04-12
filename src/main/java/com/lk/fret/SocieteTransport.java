package com.lk.fret;

import org.jspace.Space;

public class SocieteTransport implements Runnable {

    private Space tupleSpaceTransport;
    private OffreTransport offreTransport;

    public SocieteTransport(Space tupleSpaceTransport) {
        this.tupleSpaceTransport = tupleSpaceTransport;
        this.offreTransport = new OffreTransport();
    }

    public void offreTransport(String type, int quantite) throws InterruptedException {
        tupleSpaceTransport.put(type, quantite);
    }

    @Override
    public void run() {

    }
}
