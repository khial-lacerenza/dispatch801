package com.lk.fret.model;

import com.jfoenix.controls.JFXListView;
import org.jspace.Space;

public class SocieteTransport extends Entreprise {
    private static int ID = 1;
    private Space tupleSpaceTransport;
    private JFXListView<String> transportOffre;

    public SocieteTransport(Space tupleSpaceTransport, JFXListView<String> transportList) {
        super(tupleSpaceTransport, new OffreTransport(), "SocieteTransport", ID);
        transportList.getItems().add("Société de Transport - " + ID);
        ID++;
    }

    public SocieteTransport(Space tupleSpaceTransport, JFXListView<String> transportList, JFXListView<String> transportOffreList) {
        super(tupleSpaceTransport, new OffreTransport(), "SocieteTransport", ID);
        transportList.getItems().add("Société de Transport - " + ID);
        this.transportOffre = transportOffreList;
        ID++;
    }

    @Override
    public void ajoutOffre() throws InterruptedException {
        super.ajoutOffre();
        transportOffre.getItems().add(getId() + " : " + getOffre());
    }
}
