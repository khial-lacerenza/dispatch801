package com.lk.fret;

import com.lk.fret.model.FourniseurMateriau;
import com.lk.fret.model.MaitreOeuvre;
import com.lk.fret.model.SocieteTransport;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.jspace.SequentialSpace;
import org.jspace.Space;

import java.io.IOException;

public class MainPage extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;

    Space espaceTransport = new SequentialSpace();
    Space espaceMateriau = new SequentialSpace();
    MaitreOeuvre maitreOeuvre = new MaitreOeuvre(espaceMateriau, espaceTransport);

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Fret");
        
        initRootLayout();
        startJob();
    }
    /**
     * Initializes the root layout.
     */
    @FXML
    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainPage.class.getResource("MainPage.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void startJob() throws InterruptedException {

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
