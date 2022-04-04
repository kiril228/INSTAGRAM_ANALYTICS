package com.example.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;
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

public class ControllerWindowAnalyticsTwoAccount {
    AnalyticsAccount1 analyticsAccount1 = new AnalyticsAccount1();

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
            } catch (Exception e) {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
            Parent parent = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        });
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        //IMAGE VIEW 1
        executorService.execute(() -> {
            try {
                AnalyticsAccount.ImageProfile(ControllerMenuComparisonOfTwoAccounts.getUrlInstagramNavigation1(), "profileAvatar1.jpg");
                File file = new File("profileAvatar1.jpg");
                String localUrl = file.toURI().toURL().toString();
                Image image = new Image(localUrl);
                imageAccount1.setImage(image);

            } catch (Exception e) {
                try {
                    File file = new File("img.png");
                    String localUrl = file.toURI().toURL().toString();
                    Image image = new Image(localUrl);
                    imageAccount1.setImage(image);
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            }
        });


        //IMAGE VIEW 2
        executorService.execute(() -> {
            try {
                AnalyticsAccount.ImageProfile(ControllerMenuComparisonOfTwoAccounts.getUrlInstagramNavigation2(), "profileAvatar2.jpg");
                File file = new File("profileAvatar2.jpg");
                String localUrl = file.toURI().toURL().toString();
                Image image = new Image(localUrl);
                imageAccount2.setImage(image);

            } catch (Exception e1) {
                try {
                    File file = new File("img.png");
                    String localUrl = file.toURI().toURL().toString();
                    Image image = new Image(localUrl);
                    imageAccount2.setImage(image);
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //SUBS
            executorService.execute(() -> {
                sub1.setEditable(false);
                try {
                    String subs1 = ("Подписок:" + (analyticsAccount1.sub(ControllerMenuComparisonOfTwoAccounts.getUrl1())));
                    sub1.setText(subs1);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        executorService.execute(() -> {
            sub2.setEditable(false);
            try {
                String subs2 = ("Подписок:" + (analyticsAccount1.sub(ControllerMenuComparisonOfTwoAccounts.getUrl2())));
                sub2.setText(subs2);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        //FOLLOWERS
        executorService.execute(() -> {
            followers1.setEditable(false);
            try {
                String follower1 = ("Подписчиков:" + (analyticsAccount1.followers(ControllerMenuComparisonOfTwoAccounts.getUrl1())));
                followers1.setText(follower1);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            followers2.setEditable(false);
            try {
                String follower2 = ("Подписчиков:" + (analyticsAccount1.followers(ControllerMenuComparisonOfTwoAccounts.getUrl2())));
                followers2.setText(follower2);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        //POSTS
        executorService.execute(() -> {
            posts1.setEditable(false);
            try {
                String post1 = ("Постов:" + (analyticsAccount1.posts(ControllerMenuComparisonOfTwoAccounts.getUrl1())));
                posts1.setText(post1);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });



        executorService.execute(new Runnable() {
            @Override
            public void run() {
                posts2.setEditable(false);
                try {
                    String post2 = ("Постов:" + (analyticsAccount1.posts(ControllerMenuComparisonOfTwoAccounts.getUrl2())));
                    posts2.setText(post2);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.execute(() -> {
            nickNameAccount1.setEditable(false);
            nickNameAccount1.setText(ControllerMenuComparisonOfTwoAccounts.getACCOUNT_NAME_1());
        });

        executorService.execute(() -> {
            nickNameAccount2.setEditable(false);
            nickNameAccount2.setText(ControllerMenuComparisonOfTwoAccounts.getACCOUNT_NAME_2());
        });
        executorService.shutdown();

    }
    }

