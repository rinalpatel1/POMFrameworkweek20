package com.demo.nopcommercetests;

import com.demo.nopcommerce.Base.BasePage;
import com.demo.nopcommerce.Pages.HomePage;
import com.demo.nopcommerce.Pages.LoginPage;
import com.demo.nopcommerce.Pages.RegistrationPage;
import com.demo.nopcommerce.Utility.Constants;
import com.demo.nopcommerce.Utility.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegistrationPageTest {

    BasePage basePage;
    Properties prop;
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    RegistrationPage registrationPage;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String browser = prop.getProperty("browser");
        driver = basePage.initialiseDriver(browser);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
        registrationPage = loginPage.doRegister();
    }
    @Test (priority =1)
    public void verifyRegistrationPageTitle() {
        String title = registrationPage.getRegistrationPageTitle();
        System.out.println("Registration Page title is: " + title);
        Assert.assertEquals(title, Constants.REGISTER_PAGE_TITLE);
    }
  //  @DataProvider
  //  public Object[][] getRegTestData(){
      //  Object[][] data = ExcelUtil.getRegData(Constants.REG_SHEET_NAME);
      //  return data;

    @Test (priority=2)
    public void registerUser()throws InterruptedException{
        registrationPage.registrationUser(prop.getProperty("FN"),prop.getProperty("LN"),prop.getProperty("day"),
                prop.getProperty("month"),prop.getProperty("year"),prop.getProperty("email"),prop.getProperty("cn"),
                prop.getProperty("pwd"),prop.getProperty("CP"));
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }



}
