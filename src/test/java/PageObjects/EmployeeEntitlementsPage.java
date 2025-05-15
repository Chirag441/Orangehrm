package PageObjects;

import Utlilies.Genricutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

public class EmployeeEntitlementsPage {
    WebDriver driver;
    Genricutils genricutils;
    Properties properties;
    By dropdown = By.xpath("//nav[@aria-label=\"Topbar Menu\"]//li/span[text()=\"Entitlements \"]");
    By myentitlements = By.xpath("//ul[@class=\"oxd-dropdown-menu\"]/li");
    By leavetype = By.xpath("//div[@class=\"oxd-table-card\"]/div/div[1]");
    By leavecount =By.xpath("//div[@class=\"oxd-table-card\"]/div/div[5]");

    public  EmployeeEntitlementsPage(WebDriver driver)
    {
         this.driver=driver;

    }

    public void setGenricutils(Genricutils genricutils)
    {
        this.genricutils =genricutils;
        properties=genricutils.getProperty();
    }

    public  void switchToEntitilement()
    {
        By xpath =By.xpath("//div[@class=\"oxd-toast-icon-container\"]");
        genricutils.waitForElementInvisibility(xpath);

        driver.findElement(dropdown).click();
        driver.findElement(myentitlements).click();
    }

    public void VerifyLeave()
    {
        String value1,value2;

        value1 = driver.findElement(leavetype).getText();
     value2 = properties.getProperty("Leavetype");
     Assert.assertEquals(value2, value1);

     value1 = driver.findElement(leavecount).getText();
     value2 = properties.getProperty("LeaveCount");
     Assert.assertEquals(value2, value1);
    }
}
