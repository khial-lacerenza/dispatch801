package com.lk.fret.controller;

import com.jfoenix.controls.JFXListView;

public class MainPageController {

    public JFXListView<String> transportList;
    public JFXListView<String> materiauxList;

    public void initialize() {
        transportList.getItems().addAll("Bus", "Tuk Tuk", "Car", "Bike", "Boat");
        materiauxList.getItems().addAll("Bus", "Tuk Tuk", "Car", "Bike", "Boat");
    }

}
