package com.example.test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ControllerEnterInstagramWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button close;

    @FXML
    void initialize() {
        close.setOnAction(actionEvent -> {
            close.getScene().getWindow().hide();
        });

    }

}
