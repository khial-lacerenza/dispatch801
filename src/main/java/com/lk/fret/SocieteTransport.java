package com.lk.fret;

import org.jspace.Space;

public class SocieteTransport implements Runnable {

    private static int ID =0;
    private int id;
    private Space tupleSpaceTransport;
    private OffreTransport offreTransport;

    public SocieteTransport(Space tupleSpaceTransport) {
        this.id = ID++;
        this.tupleSpaceTransport = tupleSpaceTransport;
        this.offreTransport = new OffreTransport();
    }

    public void ajouteOffre() throws InterruptedException {
        tupleSpaceTransport.put("offre", offreTransport);
    }

    @Override
    public void run() {

    }
}
