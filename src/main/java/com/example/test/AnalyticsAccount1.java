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

public class AnalyticsAccount1 implements parseAccount{


    @Override
    public String posts(String URL) {
        Document document;
        String post = null;
        try {
            document = Jsoup.connect(URL).get();
            Element posts = document.getElementById("numbers-posts");

            assert posts != null;
            post = posts.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
       if(post != null){return  post;}
       else {return "Информации не найдено";}
    }

    @Override
    public String sub(String URL) {
        Document document;
        String subj = null;
        try {
            document = Jsoup.connect(URL).get();
            Elements sub = document.getElementsByClass("num-follows");
            subj = sub.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(subj != null){return  subj;}
        else {return "Информации не найдено";}
    }


    @Override
    public String followers(String URL) {
        Document document;
        String foll = null;
        try {
            document = Jsoup.connect(URL).get();
            Elements followers = document.getElementsByClass("num-followers");
            foll = followers.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(foll != null){return  foll;}
        else {return "Информации не найдено";}
    }

    @Override
    public void ImageProfile(String url, String path) throws  Exception {
        System.setProperty("webdriver.chrome.driver","Selenium\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(3000);
        WebElement webElement = driver.findElement(By.tagName("img"));
        String newURL = webElement.getAttribute("src");
        downloadFiles(newURL, path);
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
