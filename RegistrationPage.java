package com.demo.nopcommerce.Pages;
import com.demo.nopcommerce.Utility.Constants;
import com.demo.nopcommerce.Utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class RegistrationPage {
    WebDriver driver;
    Utils utils;
    By register = By.className("ico-register");
    By genderButton = By.id("gender-female");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By Day = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]");
    By Month = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]");
    By Year = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]");
    By emailId = By.id("Email");
    By companyName = By.id("Company");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");
    By jewelry = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a");
    By flowerGirlBracelet = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/h2/a");
    By addtocart = By.id("add-to-cart-button-41");
    By popuplink = By.xpath("/html/body/div[5]/div/p/a");
    By checkbox = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/div[3]/input");
    By checkOut = By.id("checkout");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }
    public String getRegistrationPageTitle() {
        return utils.waitForTitlePresent(Constants.REGISTER_PAGE_TITLE, 10);
    }



        public void registrationUser(String FN, String LN, String day,String month, String year,
                String email, String cn, String pwd, String CP) throws InterruptedException {
            utils.doClick(register);
            utils.doClick(genderButton);
            Thread.sleep(3000);
            utils.doSendKeys(firstName,FN);
            Thread.sleep(3000);
            utils.doSendKeys(lastName,LN);
            Thread.sleep(3000);
            utils.selectValueFromDropDown(Day,day);
            Thread.sleep(3000);
            utils.selectValueFromDropDown(Month,month);
            Thread.sleep(3000);
            utils.selectValueFromDropDown(Year,year);
            Thread.sleep(3000);
            utils.doSendKeys(emailId,email);
            Thread.sleep(3000);
            utils.doSendKeys(companyName,cn);
            Thread.sleep(3000);
            utils.doSendKeys(password,pwd);
            Thread.sleep(3000);
            utils.doSendKeys(confirmPassword,CP);
            Thread.sleep(3000);
            utils.doClick(registerButton);
            Thread.sleep(3000);
            utils.doClick(jewelry);
            Thread.sleep(3000);
            utils.doClick(flowerGirlBracelet);
            Thread.sleep(3000);
            utils.doClick(addtocart);
            Thread.sleep(3000);
            utils.doClick(popuplink);
            Thread.sleep(3000);
            utils.doClick(checkbox);
            Thread.sleep(3000);
            utils.doClick(checkOut);
            Thread.sleep(3000);



        }
    }

