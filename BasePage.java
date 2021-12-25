package com.demo.nopcommerce.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    WebDriver driver;
    Properties prop;
    FileInputStream file;

    // This method is used to inilize the driver on the basis of browsername.
    //Params browserName-
    //returns: driver

    public WebDriver initialiseDriver(String browserName) {
        if (browserName.equals("chrome")) {
            //System.setProperty("webdriver.chrome.driver".....)
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "src/test/resources/BrowserDriver/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/BrowserDriver/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.out.println(browserName + "Browser is invalid, please enter correct browser name");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;
    }

    //This menthod is used to read properties from config.properties file
    //returns prop
    public Properties initialiseProperties() {
        prop = new Properties();

        try {//location of file
            file = new FileInputStream("C:\\Users\\rinal\\IdeaProjects\\FrameworkPom3\\" +
                    "src\\test\\resources\\TestData\\config.properties");
            prop.load(file);// loading file
        } catch (FileNotFoundException e) {
            System.out.println("Congig file is not found, please check....");
        } catch (IOException e) {
            System.out.println("Properties could not be loaded.....");
            e.printStackTrace();
        }
        return prop;
    }
}