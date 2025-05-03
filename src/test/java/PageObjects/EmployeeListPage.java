package PageObjects;

import Utlilies.Genricutils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class EmployeeListPage {
    WebDriver driver;
    Genricutils genricutils;
    By employeeID = By.xpath("(//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[2])[2]/input");
    By searchButton = By.xpath("//button[@type=\"submit\"]");
    By seatchresult = By.xpath("//div[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]/span");
    By employeedeletebutton = By.xpath("//div[@class=\"oxd-table-row oxd-table-row--with-border oxd-table-row--clickable\"]/div[9]/div/button[2]");
    By acceptverification = By.xpath("//div[@class=\"orangehrm-modal-footer\"]/button[2]");
    By fotter =By.xpath("//p[@class=\"oxd-text oxd-text--p orangehrm-copyright\"][1]");
    By deleteverifiactionpopup = By.xpath("//div[@class=\"oxd-toast-content oxd-toast-content--info\"]/p[2]");

    public EmployeeListPage(WebDriver driver)
    {
        this.driver=driver;

    }

    public  void setGenricutils(Genricutils genricutils)
    {
        this.genricutils=genricutils;
    }
    public  void switchSection()
    {
      genricutils.topMenu("Employee List");
    }
  public boolean searchEmployee(String id)
    {

        String results;
       // driver.findElement(employeeID).click();
      driver.findElement((employeeID)).sendKeys(Keys.CONTROL,"a");
        driver.findElement((employeeID)).sendKeys(Keys.BACK_SPACE);
        driver.findElement(employeeID).sendKeys("1012");
        driver.findElement(searchButton).click();
        genricutils.waitForElementVisibility(fotter);
        results =driver.findElement(seatchresult).getText();
        if(results.contains("No Records Found"))
        {
            return false;

        }
            else
        {
            //String xpath = "//div[text()='0450']";
            By xpath = By.xpath("//div[text()='"+id+"']");
             return genricutils.elementStatus(xpath);
        }


        //return !results.contains("No Records Found");

        // true= if employee exists
        //false = if not exists
    }

    public void deleteEmployee()
    {

      driver.findElement(employeedeletebutton).click();
       genricutils.waitForElementVisibility(acceptverification);
     // driver.findElement(acceptverification).click();
        driver.findElement(acceptverification).click();
        genricutils.waitForElementVisibility(deleteverifiactionpopup);
       // System.out.println(driver.findElement(deleteverifiactionpopup).getText());

    }

}
