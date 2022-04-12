package com.lk.fret;

import org.jspace.Space;

public class SocieteTransport implements Runnable {

    private static int ID =0;
    private final int id;
    private final Space tupleSpaceTransport;
    private OffreTransport offreTransport;

    public SocieteTransport(Space tupleSpaceTransport) {
        this.id = ID++;
        this.tupleSpaceTransport = tupleSpaceTransport;
        this.offreTransport = new OffreTransport();
    }

    public void ajoutOffre() throws InterruptedException {
        tupleSpaceTransport.put("offre-" + id, offreTransport);
    }

    @Override
    public void run() {

    }
}
