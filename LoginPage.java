package com.demo.nopcommerce.Pages;


import com.demo.nopcommerce.Utility.Constants;
import com.demo.nopcommerce.Utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    Utils utils;

    //1. create page object/object repository in locators form

    By emailId = By.id("Email");
    By password = By.id("Password");
    By loginButton = By.className("login-button");
    By registerButton = By.className("register-button");

    //2. create constructor of page class.
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }
    //3. Page actions /page methods

    public String getPageTitle() throws InterruptedException {
        return utils.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 5);
    }

    public boolean verifyRegisterButton() throws InterruptedException {
        return utils.isElementDisplayed(registerButton);

    }

    public RegistrationPage doRegister() {
        utils.doClick(registerButton);
        return new RegistrationPage(driver);
    }

    public HomePage doLogin(String username, String pwd) throws InterruptedException {
        utils.doSendKeys(emailId, username);
        utils.doSendKeys(password, pwd);
        utils.doClick(loginButton);
//        utils.waitForTitlePresent(Constants.HOME_PAGE_TITLE, 5);

        System.out.println("Credentials are: " + username + " - " + pwd);

        return new HomePage(driver);
    }
}