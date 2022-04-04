package com.example.test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerStartWindow {
    private static String ACCOUNT_NAME;
    private static String URL;
    private static String URL_INSTAGRAM_NAVIGATION;



    public static String getAccountName() {
        return ACCOUNT_NAME;
    }

    public static String URL() {
        return URL;
    }

    public static String getUrlInstagramNavigation() {return URL_INSTAGRAM_NAVIGATION;}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nickNameInstagramAccountTextField;

    @FXML
    public Button CompareAccountButton;

    @FXML
    private Button viewAnalyticsButton;

    @FXML
    void initialize() {

        //ANALYTICS ONE ACCOUNT
        viewAnalyticsButton.setOnAction(actionEvent -> {
            ACCOUNT_NAME = nickNameInstagramAccountTextField.getText();

            if (!ACCOUNT_NAME.equals("")) {
                URL = "https://insta-stories.online/ru/posts/" + ACCOUNT_NAME;
                URL_INSTAGRAM_NAVIGATION = "https://instanavigation.com/ru/profile/" + ACCOUNT_NAME;
                viewAnalyticsButton.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/test/analyticswindow.fxml"));
                try {
                    fxmlLoader.load();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Parent parent = fxmlLoader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(parent));
                stage.showAndWait();
            } else {
                viewAnalyticsButton.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/test/pleaswriteaccount.fxml"));
                try {
                    fxmlLoader.load();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Parent parent = fxmlLoader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(parent));
                stage.show();
            }

        });



        //COMPARE ACCOUNTS
        CompareAccountButton.setOnAction(actionEvent -> {
            viewAnalyticsButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/test/comparisonOfTwoAccounts.fxml"));
            try {
                fxmlLoader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Parent parent = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.showAndWait();
            });



    }
}
