package Utlilies;

import PageObjects.Objectfile;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Genricutils {
    WebDriver driver;
        String excelfilelloacation = "//src//test//resources//EmployeeDetails.xlsx";
    By menueButton = By.xpath("//button[@class=\"oxd-icon-button oxd-main-menu-button\"]");

    By menuelist = By.xpath("//a[@class='oxd-main-menu-item']");
    XSSFWorkbook workbook;
    public XSSFSheet sheet;
    JavascriptExecutor js;//(JavascriptExecutor)  driver;
    WebDriverWait wait;
    Properties prop;
    String filepath = "//src//test//resources//employee.properties";

    public Objectfile objectfile;
    public int employeeid;
    public String employeeusermane;
    public String employeepassword;

    public void switchFromTopMenue(String name) {
        topMenu(name);
    }


    public Genricutils(WebDriver driver, Objectfile objectfile) {
        this.driver = driver;
        this.objectfile = objectfile;
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public void SideMenu(String tab) {

        if (!elementStatus(menuelist)) {
            driver.findElement(menueButton).click();
            //System.out.println("button Clicked");
        }
        driver.findElement(By.xpath("//span[text()=\"" + tab + "\"]")).click();
        driver.findElement(menueButton).click();

    }

    public boolean elementStatus(By element) {

        boolean s;
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            driver.findElement(element);
            s = true;
        } catch (Exception e) {
            s = false;
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        }

        return s;

    }

    public void topMenu(String tab) {
        By option = By.xpath("//a[text()='" + tab + "']");//Add Employee']");
        driver.findElement(option).click();

    }

    public void loadExcelFile() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + excelfilelloacation);


        } catch (FileNotFoundException e) {
            System.out.println("Enable to load ExcelFile");
        }


        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println(" Unable to Load Workbook");
        }
        sheet = workbook.getSheetAt(0);
    }

    public void scroll(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


    public boolean waitForElementVisibility(By xpath) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    public boolean waitForElementInvisibility(By xpath) {
        try {
            wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(xpath)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public byte[] getScreenshot()
    {

      File srcshot  =   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        byte [] screenshot = new byte[0];
        try {
            screenshot =FileUtils.readFileToByteArray(srcshot);
        }
        catch (IOException e)
        {
            System.out.println("Unable to take screenshot");
        }
        return screenshot;
    }


    void employeePropertyFile()
    {

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(System.getProperty("user.dir") + filepath);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find Properties File");
        }
        prop = new Properties();
        try {
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("Unable to load Properties File");
        }
    }

    public Properties getProperty()
    {
        if(prop==null)
        {
            employeePropertyFile();
        }

            return prop;
    }


   public void dropdownlist(By dropdownXpath, String value)
    {
        waitForElementVisibility(dropdownXpath);
       List<WebElement> ele=  driver.findElements(dropdownXpath);
      for (WebElement options : ele)
      {
          if(options.getText().equalsIgnoreCase(value))
          {
              options.click();
              break;
          }
      }
    }


}
