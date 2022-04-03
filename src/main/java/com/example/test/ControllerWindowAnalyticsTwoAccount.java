package com.example.test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControllerWindowAnalyticsTwoAccount {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backCompare;

    @FXML
    private Button backToMenu;

    @FXML
    private TextField followers1;

    @FXML
    private TextField followers2;

    @FXML
    private ImageView imageAccount1;

    @FXML
    private ImageView imageAccount2;

    @FXML
    private TextField nickNameAccount1;

    @FXML
    private TextField nickNameAccount2;

    @FXML
    private TextField posts1;

    @FXML
    private TextField posts2;

    @FXML
    private TextField sub1;

    @FXML
    private TextField sub2;

    @FXML
    void initialize() {
        //BACK BUTTON
        backToMenu.setOnAction(actionEvent -> {
            backToMenu.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/test/startWindow.fxml"));
            try {
                fxmlLoader.load();
            } catch (Exception e){
                e.printStackTrace();
            }
            Parent parent = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        });
        backCompare.setOnAction(actionEvent -> {
            backCompare.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/test/comparisonOfTwoAccounts.fxml"));
            try {
                fxmlLoader.load();
            } catch (Exception e){
                e.printStackTrace();
            }
            Parent parent = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        });
   }

}

