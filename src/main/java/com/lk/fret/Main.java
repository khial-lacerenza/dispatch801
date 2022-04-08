package com.lk.fret;

import org.jspace.FormalField;
import org.jspace.SequentialSpace;
import org.jspace.Space;

public class Main {

    public static void main(String[] argv) throws InterruptedException {
        Space inbox = new SequentialSpace();

        Space espaceTransport = new SequentialSpace();
        Space espaceMateriau = new SequentialSpace();

        inbox.put("Hello World!");
        Object[] tuple = inbox.get(new FormalField(String.class));
        System.out.println(tuple[0]);

        MaitreOeuvre maitreOeuvre = new MaitreOeuvre(espaceMateriau, espaceTransport);
        SocieteTransport societeTransport = new SocieteTransport(espaceTransport);
        FourniseurMateriau fourniseurMateriau = new FourniseurMateriau(espaceMateriau);


    }

}
