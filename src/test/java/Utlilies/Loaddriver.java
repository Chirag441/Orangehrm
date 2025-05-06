package Utlilies;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Loaddriver {
    WebDriver driver;
    Properties prop;
    String filepath = "//src//test//resources//global.properties";

    public WebDriver getDriver() {


        FileInputStream fis = null;

        try {
            fis = new FileInputStream(System.getProperty("user.dir") + filepath);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find Properties File");
        }
        prop = new Properties();
        try {
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("Unable to load Properties File");
        }


        String URL = prop.getProperty("URL");


        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
        return driver;
    }


}
