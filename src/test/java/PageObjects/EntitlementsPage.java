package PageObjects;

import Utlilies.Genricutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;

public class EntitlementsPage {
    WebDriver driver;
    Properties properties;
    By dropdown = By.xpath("//nav[@aria-label=\"Topbar Menu\"]//li/span[text()=\"Entitlements \"]");
    By addentitlements = By.xpath("//ul[@class=\"oxd-dropdown-menu\"]/li[1]");
    By empName = By.xpath("//div[@class=\"oxd-autocomplete-wrapper\"]/div/input");
    By empLeave =By.xpath("//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]/div[2]/input");
    By leaveType = By.xpath("(//div[@class=\"oxd-select-text--after\"]/i)[1]");
    By leavePeriod = By.xpath("(//div[@class=\"oxd-select-text--after\"]/i)[2]");
    By leaveDropdown=By.xpath("//div[@role=\"listbox\"]/div/span");
    Genricutils genricutils;
    By saveButton = By.xpath("//button[@type=\"submit\"]");
    By confirmButton = By.xpath("//div[@class=\"orangehrm-modal-footer\"]/button[@type=\"button\"][2]");

    public EntitlementsPage(WebDriver driver)
    {
        this.driver =driver;
    }

    public void setGenricutils(Genricutils genricutils)
    {
        this.genricutils =genricutils;
        properties=genricutils.getProperty();
    }

    public void switchToEntitlements()
    {

        By xpath =By.xpath("//div[@class=\"oxd-toast-icon-container\"]");
        genricutils.waitForElementInvisibility(xpath);
       driver.findElement(dropdown).click();

       driver.findElement(addentitlements).click();

    }

    public void employeeLeaveDetails()
    {
      String value;

      value=properties.getProperty("EmployeeName");
      driver.findElement(empName).sendKeys(value);
      genricutils.dropdownlist(leaveDropdown,value);

        driver.findElement(leaveType).click();
        value=properties.getProperty("Leavetype");
       genricutils.dropdownlist(leaveDropdown,value);

        driver.findElement(leavePeriod).click();
        value=properties.getProperty("LeavePreiod");
        genricutils.dropdownlist(leaveDropdown,value);

        value =properties.getProperty("LeaveCount");
        driver.findElement(empLeave).sendKeys(value);

        driver.findElement(saveButton).click();
        driver.findElement(confirmButton).click();



    }

//    void dropdownlist(By dropdownXpath, String value)
//    {
////        genricutils.waitForElementVisibility(dropdownXpath);
//      List<WebElement> ele=  driver.findElements(dropdownXpath);
//      for (WebElement options : ele)
//      {
//          if(options.getText().equalsIgnoreCase(value))
//          {
//              options.click();
//              break;
//          }
//      }
//    }

}
