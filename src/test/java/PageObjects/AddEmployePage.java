package PageObjects;

import Utlilies.Genricutils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class AddEmployePage {
    WebDriver driver;
    XSSFSheet sheet;
    Genricutils genricutils;
    EmployeeListPage employeeListPage;
    String employeefeild = "(//input[contains(@class,'oxd-input oxd-input')])[";
    By statuselement = By.xpath("//label[text()='Status']");
    By toggelbutton = By.xpath("//span[contains(@class,'oxd-switch-input')]");
    By savebutton = By.xpath("//button[@type='submit']");
    By personaldetails = By.xpath("//a[text()=\"Personal Details\"]");
    By alreadyexistserrormessage = By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]");
    String username;

    public AddEmployePage(WebDriver driver) {
        this.driver = driver;
    }


    public void setGenricutils(Genricutils genricutils) {
        this.genricutils = genricutils;
        employeeListPage = genricutils.objectfile.getEmployeeListPage();

    }


    public void createEmployee() {
        String value, xpath;
        genricutils.switchFromTopMenue("Add Employee");

        WebElement ele = driver.findElement(toggelbutton);

        if (!genricutils.elementStatus(statuselement)) {
            ele.click();
        }


        for (int i = 1; i < 8; i++) {
            this.sheet = genricutils.sheet;
            value = String.valueOf(sheet.getRow((i - 1)).getCell(1));
            xpath = employeefeild + (i + 1) + "]";
            if (i == 4) {
                int id;
                id = Integer.parseInt(value.split("\\.")[0]);
                driver.findElement(By.xpath(xpath)).sendKeys(Keys.CONTROL, "a");
                driver.findElement(By.xpath(xpath)).sendKeys(Keys.BACK_SPACE);
                driver.findElement(By.xpath(xpath)).sendKeys(String.valueOf(id));
                genricutils.employeeid = id;

            } else {
                if (i == 6) {
                    genricutils.employeepassword = value;
                }
                if (i == 5) {
                    username = value;
                }
                driver.findElement(By.xpath(xpath)).sendKeys(value);
            }


        }
        ele = driver.findElement(savebutton);
        genricutils.scroll(ele);

        if (genricutils.elementStatus(alreadyexistserrormessage)) {

            String errormessage = driver.findElement(alreadyexistserrormessage).getText();

            if (errormessage.contains("Employee Id")) {
                employeeListPage.setGenricutils(genricutils);
                Assert.assertTrue(employeeListPage.searchEmployee(genricutils.employeeid));
                employeeListPage.deleteEmployee();
                Assert.assertFalse(employeeListPage.searchEmployee(genricutils.employeeid));
                createEmployee();
            }
            if (errormessage.contains("Username")) {
                username = username + genricutils.employeeid;
                xpath = employeefeild + "6]";
                driver.findElement(By.xpath(xpath)).sendKeys(Keys.CONTROL, "a");
                driver.findElement(By.xpath(xpath)).sendKeys(Keys.BACK_SPACE);
                driver.findElement(By.xpath(xpath)).sendKeys(username);

            }

        }
        driver.findElement(savebutton).click();
        genricutils.employeeusermane = username;
        genricutils.waitForElementVisibility(personaldetails);
    }

}
