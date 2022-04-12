package com.lk.fret;

import org.jspace.FormalField;
import org.jspace.SequentialSpace;
import org.jspace.Space;

public class Main {

    public static void main(String[] argv) throws InterruptedException {

        Space espaceTransport = new SequentialSpace();
        Space espaceMateriau = new SequentialSpace();

        MaitreOeuvre maitreOeuvre = new MaitreOeuvre(espaceMateriau, espaceTransport);

        maitreOeuvre.debutAppeldOffreMateriel();
        maitreOeuvre.debutAppeldOffreTransport();

//        for (int i = 0; i < 5; i++) {
        SocieteTransport societeTransport = new SocieteTransport(espaceTransport);
        FourniseurMateriau fourniseurMateriau = new FourniseurMateriau(espaceMateriau);
        new Thread(fourniseurMateriau).start();
        new Thread(societeTransport).start();
//        }

//        Thread.sleep(1000);
//
//        maitreOeuvre.recupOffreMateriel();
//        maitreOeuvre.recupOffreTransport();
    }
}
