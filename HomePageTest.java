package com.demo.nopcommercetests;

import com.demo.nopcommerce.Base.BasePage;
import com.demo.nopcommerce.Pages.HomePage;
import com.demo.nopcommerce.Pages.LoginPage;
import com.demo.nopcommerce.Utility.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class HomePageTest {
    BasePage basePage;
    WebDriver driver;
    Properties prop;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String webEngine = prop.getProperty("browser");
        driver = basePage.initialiseDriver(webEngine);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
        homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String hpTitle = homePage.getHomePageTitle();
        System.out.println(hpTitle);
        Assert.assertEquals(hpTitle,Constants.HOME_PAGE_TITLE,"title is mismatched");
    }
    @Test(priority = 2)
    public void verifyLogOutLinkTest(){
        Assert.assertTrue(homePage.isLogOutLinkPresent(), "Log out link not present");
        String logOutLink = homePage.getLogOutText();
        System.out.println("Log out link is: " + logOutLink);
        Assert.assertEquals(logOutLink, Constants.HOME_PAGE_LOGOUT, "Log out text mismatch");
    }

    @AfterTest
    public void tearDown(){

        driver.quit();
    }
}


