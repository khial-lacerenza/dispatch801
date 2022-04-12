package com.lk.fret;

import org.jspace.Space;

public class SocieteTransport implements Runnable {

    private Space tupleSpaceTransport;

    public SocieteTransport(Space tupleSpaceTransport) {
        this.tupleSpaceTransport = tupleSpaceTransport;
    }

    public void offreTransport(String type, int quantite) throws InterruptedException {
        tupleSpaceTransport.put(type, quantite);
    }

    @Override
    public void run() {

    }
}
