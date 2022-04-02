module com.example.test {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.jsoup;
    requires org.seleniumhq.selenium.api;
    requires org.seleniumhq.selenium.chrome_driver;



    opens com.example.test to javafx.fxml;
    exports com.example.test;
}