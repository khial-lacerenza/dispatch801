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

    @FXML
    public JFXListView<String> maitreOeuvreChoix;
    @FXML
    public JFXListView<String> transportList;
    @FXML
    public JFXListView<String> materiauxList;
    @FXML
    public JFXListView<String> transportOffreList;
    @FXML
    public JFXListView<String> materiauxOffreList;
    @FXML
    public Label labelTransportOffre;
    @FXML
    public Label labelMateriauxOffre;
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

        MaitreOeuvre maitreOeuvre = new MaitreOeuvre(espaceMateriau, espaceTransport, labelMateriauxOffre, labelTransportOffre);
        Thread maitreOeuvreThread = new Thread(maitreOeuvre);
        maitreOeuvreThread.setDaemon(true);
        maitreOeuvreThread.start();

        for (int i = 0; i < 5; i++) {
            FourniseurMateriau fourniseurMateriau = new FourniseurMateriau(espaceMateriau, materiauxList, materiauxOffreList, maitreOeuvreChoix);
            SocieteTransport societeTransport = new SocieteTransport(espaceTransport, transportList, transportOffreList, maitreOeuvreChoix);
            Thread fm = new Thread(fourniseurMateriau);
            Thread st = new Thread(societeTransport);
            fm.setDaemon(true);
            st.setDaemon(true);
            fm.start();
            st.start();
        }
    }
}
