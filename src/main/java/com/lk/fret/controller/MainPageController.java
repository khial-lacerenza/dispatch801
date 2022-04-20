package com.lk.fret.controller;

import com.lk.fret.model.FourniseurMateriau;
import com.lk.fret.model.MaitreOeuvre;
import com.lk.fret.model.SocieteTransport;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.jspace.SequentialSpace;
import org.jspace.Space;

public class MainPageController {

    Space espaceTransport = new SequentialSpace();
    Space espaceMateriau = new SequentialSpace();
    MaitreOeuvre maitreOeuvre = new MaitreOeuvre(espaceMateriau, espaceTransport);

    @FXML
    public GridPane gridPane;
    @FXML
    private Button startBtn;

    @FXML
    protected void onstartBtnClick() throws InterruptedException {
        gridPane.add(new Label("Hello World"), 0, 0);
        startNego();
    }

    public void startNego() throws InterruptedException {

        maitreOeuvre.debutAppeldOffreMateriel();
        maitreOeuvre.debutAppeldOffreTransport();

        for (int i = 0; i < 5; i++) {
            FourniseurMateriau fourniseurMateriau = new FourniseurMateriau(espaceMateriau);
            SocieteTransport societeTransport = new SocieteTransport(espaceTransport);
            new Thread(fourniseurMateriau).start();
            new Thread(societeTransport).start();
        }

        Thread.sleep(1000);

        maitreOeuvre.recupOffreMateriel();
        maitreOeuvre.recupOffreTransport();
    }
}
