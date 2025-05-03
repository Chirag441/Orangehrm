package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {
    WebDriver driver;
   By text = By.xpath("//h6[text()='Dashboard']");
   By userProfile= By.xpath("//p[@class=\"oxd-userdropdown-name\"]");
   By logout = By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]");

    public Homepage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void Verify()
    {
        Assert.assertEquals(driver.findElement(text).getText(), "Dashboard");

    }

    public void LogOut()
    {
        driver.findElement(userProfile).click();
        driver.findElement(logout).click();
       // driver.quit();
    }
}
