package Utlilies;

import PageObjects.Objectfile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Genricutils
{
WebDriver driver;
    Properties prop;
    String excelfilelloacation="//src//test//java//resource//EmployeeDetails.xlsx";
    String propertyfilelocation="//src//test//java//resource//external.properties";
    By menueButton = By.xpath("//button[@class=\"oxd-icon-button oxd-main-menu-button\"]");

     By menuelist = By.xpath("//a[@class='oxd-main-menu-item']");
   XSSFWorkbook workbook ;
    public   XSSFSheet sheet;
    JavascriptExecutor js ;//(JavascriptExecutor)  driver;
    WebDriverWait wait ;

    public  Objectfile objectfile;
    public  int employeeid;
    public String employeeusermane;
    public String employeepassword;

    public  void switchFromTopMenue(String name)
    //switchToEmployeeSection
    {
        topMenu(name);
    }






public Genricutils(WebDriver driver  , Objectfile objectfile)
{
    this.driver=driver;
    this.objectfile =objectfile;
    js=(JavascriptExecutor)  driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));

}

 public void SideMenu(String tab)
 {

     if(!elementStatus(menuelist))
    {
        driver.findElement(menueButton).click();
        //System.out.println("button Clicked");
    }
   driver.findElement(By.xpath("//span[text()=\""+tab+"\"]")).click();
     driver.findElement(menueButton).click();

 }
 public boolean elementStatus(By element)
 {

     boolean s ;
     try{
         driver.findElement(element);
         s=true;
     }catch (Exception e)
     {
         s=false;
     }

     return s;

 }

public void topMenu(String tab)
{
    By option = By.xpath("//a[text()='"+tab+"']");//Add Employee']");
    driver.findElement(option).click();

}

public void loadExcelFile()
{
    FileInputStream fis = null ;
    try {
        fis= new FileInputStream(System.getProperty("user.dir")+excelfilelloacation);
      //  loadPropertyFile();

    } catch (FileNotFoundException e) {
        System.out.println("Enable to load ExcelFile");
    }
//    catch (IOException e) {
//        System.out.println("Enable to load Property File");
//    }


    try {
        workbook =new XSSFWorkbook(fis);
    } catch (IOException e) {
        System.out.println(" Unable to Load Workbook");
    }
    sheet= workbook.getSheetAt(0);
}

public  void scroll(WebElement element)
{
    js.executeScript("arguments[0].scrollIntoView();",element);
}


public void loadPropertyFile() throws IOException
{

    FileInputStream propertyfile = null;

        propertyfile = new FileInputStream(System.getProperty("user.dir")+propertyfilelocation);
        prop = new Properties();
        prop.load(propertyfile);

}
public boolean waitForElementVisibility(By xpath)
{
    try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        return true;
    } catch (Exception e) {
        return false;
    }
}

}
