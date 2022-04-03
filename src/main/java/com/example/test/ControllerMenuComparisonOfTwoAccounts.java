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

public class ControllerMenuComparisonOfTwoAccounts {
    private String ACCOUNT_NAME_1;
    private String ACCOUNT_NAME_2;
    private static String URL_1;
    private static String URL_INSTAGRAM_NAVIGATION_1;
    private static String URL_2;
    private static String URL_INSTAGRAM_NAVIGATION_2;


    public String getACCOUNT_NAME_1() {
        return ACCOUNT_NAME_1;
    }

    public String getACCOUNT_NAME_2() {
        return ACCOUNT_NAME_2;
    }

    public static String getUrl1() {
        return URL_1;
    }

    public static String getUrlInstagramNavigation1() {
        return URL_INSTAGRAM_NAVIGATION_1;
    }

    public static String getUrl2() {
        return URL_2;
    }

    public static String getUrlInstagramNavigation2() {
        return URL_INSTAGRAM_NAVIGATION_2;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button compareAccounts;

    @FXML
    private Button backToMenuButton;

    @FXML
    private TextField nickNameFirstInstagramAccountTextField;

    @FXML
    private TextField nickNameSecondInstagramAccountTextField1;

    @FXML
    void initialize() {

        //ANALYTICS TWO ACCOUNT
        compareAccounts.setOnAction(actionEvent -> {
            ACCOUNT_NAME_1 = nickNameFirstInstagramAccountTextField.getText();
            ACCOUNT_NAME_2 = nickNameSecondInstagramAccountTextField1.getText();

            if (!ACCOUNT_NAME_1.equals("") && !ACCOUNT_NAME_2.equals("")) {
                URL_1 = "https://insta-stories.online/ru/posts/" + ACCOUNT_NAME_1;
                URL_INSTAGRAM_NAVIGATION_1 = "https://instanavigation.com/ru/profile/" + ACCOUNT_NAME_1;
                URL_2 = "https://insta-stories.online/ru/posts/" + ACCOUNT_NAME_2;
                URL_INSTAGRAM_NAVIGATION_2 = "https://instanavigation.com/ru/profile/" + ACCOUNT_NAME_2;
                compareAccounts.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/test/"));
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
                compareAccounts.getScene().getWindow();
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
                stage.showAndWait();
            }

        });

        //BACK
        backToMenuButton.setOnAction(actionEvent -> {
            backToMenuButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/test/hello-view.fxml"));
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
