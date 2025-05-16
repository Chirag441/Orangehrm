package PageObjects;

import Utlilies.Basecontext;
import Utlilies.Genricutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Properties;

public class EmployeeApplyLeavePage {
    WebDriver driver;
    By applyoption = By.xpath("//a[text()=\"Apply\"]");
    By infoclose = By.xpath("//div[@role=\"button\"]");
    By leavetype = By.xpath("//div[@class=\"oxd-select-wrapper\"]");
    By dropdown = By.xpath("//div[@role=\"listbox\"]/div/span");
    By fromdate = By.xpath("(//div[@class=\"oxd-date-input\"]/input)[1]");
    By todate = By.xpath("(//div[@class=\"oxd-date-input\"]/input)[2]");
    By monthoption = By.xpath("//div[@class=\"oxd-calendar-wrapper\"]/div/ul/li[1]");
    By yearoption = By.xpath("//div[@class=\"oxd-calendar-wrapper\"]/div/ul/li[2]");

    By calanderdrowdown = By.xpath("//div[@class=\"oxd-calendar-wrapper\"]");
    String datepath = "//div[@class=\"oxd-calendar-wrapper\"]/div[3]/div";
    By partialdays = By.xpath("(//div[@class=\"oxd-select-text--after\"])[2]");
    By comments = By.xpath("//textarea");
    By applybutton = By.xpath("//button[@type=\"submit\"]");
    By sucessmessage = By.xpath("//div[@class=\"oxd-toast-content oxd-toast-content--success\"]/p");

    By monthdropdown = By.xpath("//div[@class=\"oxd-calendar-wrapper\"]/div/ul/li[1]/ul/li");

    By yeardropdown = By.xpath("//div[@class=\"oxd-calendar-wrapper\"]/div/ul/li[2]/ul/li");
    String yearpath = "//div[@class=\"oxd-calendar-wrapper\"]/div/ul/li[2]/ul/li";

    Basecontext base;
    Properties properties;
    Genricutils genricutils;

    public EmployeeApplyLeavePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setValues(Basecontext base) {
        this.base = base;
        genricutils = base.genric;
        properties = genricutils.getProperty();
    }

    public void SwitchToApply() {
        if (genricutils.elementStatus(infoclose)) {
            driver.findElement(infoclose).click();
        }
        driver.findElement(applyoption).click();
    }

    public void applyLeave() {
        String value;

        driver.findElement(leavetype).click();
        value = properties.getProperty("Leavetype");
        genricutils.dropdownlist(dropdown, value);

        driver.findElement(fromdate).click();

        genricutils.waitForElementVisibility(calanderdrowdown);
        value = properties.getProperty("LeaveFrom");
        calander(value);

        driver.findElement(todate).click();
        genricutils.waitForElementVisibility(calanderdrowdown);
        value = properties.getProperty("LeaveTo");
        calander(value);

        genricutils.waitForElementVisibility(partialdays);

        value = properties.getProperty("LeaveReason");
        driver.findElement(comments).sendKeys(value);

        driver.findElement(applybutton).click();

        genricutils.waitForElementVisibility(sucessmessage);
        value = driver.findElement(sucessmessage).getText();
        Assert.assertEquals(value, "Success");


    }

    void calander(String value) {
        By xpath;
        String date, month, year, path;
        date = value.split("-")[0].trim();
        month = value.split("-")[1].trim();
        year = value.split("-")[2].trim();

        path = yearpath + "[51]";
        xpath = By.xpath(path);

        driver.findElement(yearoption).click();
        genricutils.waitForElementVisibility(yeardropdown);
        genricutils.waitForElementVisibility(yeardropdown);
        driver.findElement(xpath).click();

        driver.findElement(monthoption).click();
        genricutils.dropdownlist(monthdropdown, month);


        path = datepath + "[" + date + "]";
        xpath = By.xpath(path);
        driver.findElement(xpath);

        driver.findElement(xpath).click();


    }


}
