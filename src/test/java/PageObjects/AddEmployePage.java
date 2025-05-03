package PageObjects;

import Utlilies.Basecontext;
import Utlilies.Genricutils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.geom.GeneralPath;

public class AddEmployePage {
    WebDriver driver;
    XSSFSheet sheet;
    Genricutils genricutils;
   String empdetails="(//input[contains(@class,'oxd-input oxd-input')])[";
   By statuselement = By.xpath("//label[text()='Status']");
   By toggelbutton =By.xpath("//span[contains(@class,'oxd-switch-input')]");
   By savebutton = By.xpath("//button[@type='submit']");
   By personaldetails = By.xpath("//a[text()=\"Personal Details\"]");
    public AddEmployePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public  void createEmployee(Genricutils genricutils)
    {
        String value , xpath;
        this.genricutils =genricutils;
        this.sheet = genricutils.sheet;
        WebElement ele = driver.findElement(toggelbutton);

        if(!genricutils.elementStatus(statuselement))
        {
            ele.click();
        }


       for(int i=1;i<8;i++) {
           value = String.valueOf(sheet.getRow((i - 1)).getCell(1));
           xpath = empdetails + (i+1) + "]";
           if(i==4)
           {
               int id;
               id= Integer.parseInt(value.split("\\.")[0]);
               driver.findElement(By.xpath(xpath)).sendKeys(Keys.CONTROL,"a");
               driver.findElement(By.xpath(xpath)).sendKeys(Keys.BACK_SPACE);
               driver.findElement(By.xpath(xpath)).sendKeys(String.valueOf(id));

           }
             else
               driver.findElement(By.xpath(xpath)).sendKeys(value);


        }
       ele=driver.findElement(savebutton);
       genricutils.scroll(ele);
       driver.findElement(savebutton).click();
       genricutils.waitForElementVisibility(personaldetails);
    }

    //a[text()="Personal Details"]
}
