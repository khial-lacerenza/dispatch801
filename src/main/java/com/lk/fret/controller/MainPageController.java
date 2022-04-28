package com.lk.fret.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.lk.fret.model.FourniseurMateriau;
import com.lk.fret.model.MaitreOeuvre;
import com.lk.fret.model.SocieteTransport;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.jspace.SequentialSpace;
import org.jspace.Space;

public class MainPageController {

    Space espaceTransport = new SequentialSpace();
    Space espaceMateriau = new SequentialSpace();
    MaitreOeuvre maitreOeuvre = new MaitreOeuvre(espaceMateriau, espaceTransport);

    public JFXListView<String> transportList;
    public JFXListView<String> materiauxList;
    public JFXListView<String> transportOffreList;
    public JFXListView<String> materiauxOffreList;

    @FXML
    private JFXButton startBtn;

    private boolean started = false;



    @FXML
    protected void onStartBtnClick() throws InterruptedException {
        if(!started)
        {
            startNego();
            started = true;
            startBtn.setDisable(true);
        }
    }

    public void startNego() throws InterruptedException {

        Thread maitreOeuvreThread = new Thread(maitreOeuvre);
        maitreOeuvreThread.setDaemon(true);
        maitreOeuvreThread.start();

        for (int i = 0; i < 5; i++) {
            FourniseurMateriau fourniseurMateriau = new FourniseurMateriau(espaceMateriau, materiauxList, materiauxOffreList);
            SocieteTransport societeTransport = new SocieteTransport(espaceTransport, transportList, transportOffreList);
            Thread fm = new Thread(fourniseurMateriau);
            Thread st = new Thread(societeTransport);
            fm.setDaemon(true);
            st.setDaemon(true);
            fm.start();
            st.start();
        }



    }
}
