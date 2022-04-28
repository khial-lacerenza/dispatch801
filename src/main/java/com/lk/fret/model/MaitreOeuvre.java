package com.lk.fret.model;

import javafx.concurrent.Task;
import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.Space;

public class MaitreOeuvre extends Task<Void> {


    private Space tupleSpaceMaterial;
    private Space tupleSpaceTransport;

    public MaitreOeuvre(Space tupleSpaceMaterial, Space tupleSpaceTransport) {
        this.tupleSpaceMaterial = tupleSpaceMaterial;
        this.tupleSpaceTransport = tupleSpaceTransport;
    }

    public void debutAppeldOffreMateriel() throws InterruptedException {
        tupleSpaceMaterial.put("appelOffreOuvert");
    }

    public void debutAppeldOffreTransport() throws InterruptedException {
        tupleSpaceTransport.put("appelOffreOuvert");
    }

    public void recupOffreMateriel() throws InterruptedException {
        boolean isEmpty = false;
        Object[] offre = tupleSpaceMaterial.getp(new FormalField(String.class), new FormalField(OffreMateriel.class));

        Offre meilleurOffre = (Offre) offre[1];
        int meilleurOffreID = Integer.parseInt( ((String) offre[0]).split("offre-")[1]);
        double ratioMeilleurOffre= (meilleurOffre.getPrix()/meilleurOffre.getQuantite()) * meilleurOffre.getDuree();

        while (!isEmpty) {
            if(offre == null) {
                isEmpty = true;
            } else {
                System.out.println("Offre materiel  : " + offre[0] + " " + offre[1]);
                double ratioOffre = (((Offre) offre[1]).getPrix()/((Offre) offre[1]).getQuantite())*((Offre) offre[1]).getDuree();

                if (ratioOffre < ratioMeilleurOffre) {
                    meilleurOffreID = Integer.parseInt(((String) offre[0]).split("offre-")[1]);
                    ratioMeilleurOffre = ratioOffre;
                }
            }
            offre = tupleSpaceMaterial.getp(new FormalField(String.class), new FormalField(OffreMateriel.class));
        }
        System.out.println("Meilleur offre materiel: " + meilleurOffreID);
        tupleSpaceMaterial.put("resultatMeilleurOffre", meilleurOffreID);
        System.out.println(tupleSpaceMaterial.get(new ActualField("resultatMeilleurOffre")));
    }

    public void recupOffreTransport() throws InterruptedException {
        boolean isEmpty = false;

        Object[] offre = tupleSpaceTransport.getp(new FormalField(String.class), new FormalField(OffreTransport.class));
        Offre meilleurOffre = (Offre) offre[1];
        int meilleurOffreID = Integer.parseInt( ((String) offre[0]).split("offre-")[1]);
        double ratioMeilleurOffre= (meilleurOffre.getPrix()/meilleurOffre.getQuantite())*meilleurOffre.getDuree();

        while (!isEmpty) {
            if (offre == null) {
                isEmpty = true;
            } else {
                System.out.println("Offre transport  : " + offre[0] + " " + offre[1]);
                double ratioOffre = (((Offre) offre[1]).getPrix()/((Offre) offre[1]).getQuantite())*((Offre) offre[1]).getDuree();

                if (ratioOffre < ratioMeilleurOffre) {
                    meilleurOffreID = Integer.parseInt(((String) offre[0]).split("offre-")[1]);
                    ratioMeilleurOffre = ratioOffre;
                }
            }
            offre = tupleSpaceTransport.getp(new FormalField(String.class), new FormalField(OffreTransport.class));
        }
        System.out.println("Meilleur offre transport: " + meilleurOffreID);
        tupleSpaceTransport.put("resultatMeilleurOffre", meilleurOffreID);
        System.out.println(tupleSpaceTransport.get(new ActualField("resultatMeilleurOffre")));
    }


    @Override
    protected Void call() throws Exception {
        debutAppeldOffreMateriel();
        debutAppeldOffreTransport();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException interrupted) {
            if (isCancelled()) {
                updateMessage("Cancelled");
            }
        }

        recupOffreTransport();
        recupOffreMateriel();
        return null;
    }
}
