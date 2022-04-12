package com.lk.fret;

import org.jspace.ActualField;
import org.jspace.Space;
import org.jspace.Tuple;

public class SocieteTransport implements Runnable {

    private static int ID = 1;
    private final int id;
    private final Space tupleSpaceTransport;
    private OffreTransport offreTransport;
    private boolean sent = false;

    public SocieteTransport(Space tupleSpaceTransport) {
        this.id = ID++;
        this.tupleSpaceTransport = tupleSpaceTransport;
        this.offreTransport = new OffreTransport();
    }

    public void ajoutOffre() throws InterruptedException {
        tupleSpaceTransport.put("offre-" + id, offreTransport);
        System.out.println("SocieteTransport " + id + " ajoute une offre");
    }

    @Override
    public void run() {
        try {
            Object[] open = tupleSpaceTransport.queryp(new ActualField("appelOffreTransportOuvert"));
            while (open != null) {
                open = tupleSpaceTransport.queryp(new ActualField("appelOffreTransportOuvert"));
                if(!sent)
                {
                    sent = true;
                    ajoutOffre();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
