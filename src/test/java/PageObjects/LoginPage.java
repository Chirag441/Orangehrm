package PageObjects;

import Utlilies.Genricutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;
    By userName = By.xpath("//p[@class='oxd-text oxd-text--p'][1]");
    By passWord = By.xpath("//p[@class='oxd-text oxd-text--p'][2]");
    By usernamefeild = By.xpath("//input[@name=\"username\"]");
    By passwordfeild = By.xpath("//input[@name=\"password\"]");
    By loginbutton = By.xpath("//button[text()=' Login ']");
    By userprofilename = By.xpath("//span[@class=\"oxd-userdropdown-tab\"]/p");
    String userprofile = "Raj rai";
    Genricutils genricutils;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setGenricutils(Genricutils genricutils) {
        this.genricutils = genricutils;

    }

    public String getUserName() {

        return driver.findElement(userName).getText().split(":")[1].trim();

    }

    public String getPassword() {
        return driver.findElement(passWord).getText().split(":")[1].trim();

    }

    public void loginAsAdmin(String username, String password) {
        driver.findElement(usernamefeild).sendKeys(username);
        driver.findElement(passwordfeild).sendKeys(password);
        driver.findElement(loginbutton).click();

    }

    public void loginAsUser() {
        driver.findElement(usernamefeild).sendKeys(genricutils.employeeusermane);
        driver.findElement(passwordfeild).sendKeys(genricutils.employeepassword);
        driver.findElement(loginbutton).click();
        verifyUser(userprofile);
    }

    public void verifyUser(String username) {

        String name = driver.findElement(userprofilename).getText();
        Assert.assertEquals(username, name);
    }

}
