package com.example.test;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;



public class AnalyticsAccount {


    public static String parseAccount(String URL) throws Exception {
        long before = System.currentTimeMillis();
        Document document = Jsoup.connect(URL).get();
        Element posts = document.getElementById("numbers-posts");
        Elements followers = document.getElementsByClass("num-followers");
        Elements sub = document.getElementsByClass("num-follows");
        long after = System.currentTimeMillis();
        String secondsComplete = Long.toString((after-before)/1000);
        if (posts != null)
            return "\nИмя профиля:" + ControllerStartWindow.getAccountName() +
                    "\n Постов: " + posts.text() +
                    "\n Подпищиков: " + followers.text() +
                    "\n Подписок: " + sub.text() +
                    "\n Время выполнения" + secondsComplete;
        else {
            return " Результат не найдено!";
        }
    }


    public static void ImageProfile ()  {
        String URL = ControllerStartWindow.getUrlInstagramNavigation();
        System.setProperty("webdriver.chrome.driver","Selenium\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
            driver.get(URL);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElement = driver.findElement(By.tagName("img"));
            String newURL = webElement.getAttribute("src");

            downloadFiles(newURL, "profileAvatar.jpg");
        driver.close();



    }

    private static void downloadFiles(String URL, String path) {
        FileOutputStream fout = null;
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new URL(URL).openStream());
            fout = new FileOutputStream(path);
            byte[] data = new byte[2048];
            int count;
            while ((count = in.read(data, 0, 2048)) != -1) {
                fout.write(data, 0, count);
                fout.flush();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                assert in != null;
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert fout != null;
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}






