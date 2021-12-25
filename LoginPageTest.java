package com.demo.nopcommercetests;

import com.demo.nopcommerce.Base.BasePage;
import com.demo.nopcommerce.Pages.LoginPage;
import com.demo.nopcommerce.Utility.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Properties;

public class LoginPageTest {

        BasePage basePage;
        WebDriver driver;
        Properties prop;
        LoginPage loginPage;

    @BeforeTest
    public void openBrowser() {
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String webEngine = prop.getProperty("browser");
        driver = basePage.initialiseDriver(webEngine);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
    }
    @Test(priority = 1)
    public void verifyLoginPageTitleTest() throws InterruptedException {
        Assert.assertEquals(loginPage.getPageTitle(), Constants.LOGIN_PAGE_TITLE,
                "Loginpage title mismatched");
    }

    @Test(priority = 2)
    public void verifyRegisterButtonTest() throws InterruptedException {
        Assert.assertTrue(loginPage.verifyRegisterButton(), "Register button is not displayed");
    }

    @Test (priority = 3)
    public void loginTest() throws InterruptedException {
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
