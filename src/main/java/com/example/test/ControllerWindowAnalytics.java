package com.example.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControllerWindowAnalytics {
    private static String PREV_ACCOUNT_NAME = "";
    private static String PREV_TEXT = "";
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField analyticsTextField;

    @FXML
    private Button backButton;

    @FXML
    private ImageView imageAccount;

    @FXML
    void initialize()  {
        //BACK BUTTON
        backButton.setOnAction(actionEvent -> {
            backButton.getScene().getWindow().hide();
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

        if(!PREV_ACCOUNT_NAME.equals(ControllerStartWindow.getAccountName())){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //TEXT FIELD
        executorService.execute(() -> {
            analyticsTextField.setEditable(false);

            try {
                PREV_TEXT = (AnalyticsAccount.parseAccount(ControllerStartWindow.URL()));
                analyticsTextField.setText(PREV_TEXT);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        //IMAGE VIEW
        executorService.execute(() -> {
            try {
                AnalyticsAccount.ImageProfile(ControllerStartWindow.getUrlInstagramNavigation(), "profileAvatar.jpg");
                File file = new File("profileAvatar.jpg");
                String localUrl = file.toURI().toURL().toString();
                Image image = new Image(localUrl);
                imageAccount.setImage(image);

            } catch (Exception e) {
                try {
                    File file = new File("img.png");
                    String localUrl = file.toURI().toURL().toString();
                    Image image = new Image(localUrl);
                    imageAccount.setImage(image);
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        executorService.shutdown();}
        else {
            File file = new File("profileAvatar.jpg");
            try {
                String localUrl = file.toURI().toURL().toString();
                Image image = new Image(localUrl);
                imageAccount.setImage(image);
                analyticsTextField.setText(PREV_TEXT);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        PREV_ACCOUNT_NAME = ControllerStartWindow.getAccountName();







    }

}
