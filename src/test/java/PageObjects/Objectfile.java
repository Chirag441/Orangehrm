package PageObjects;

import org.openqa.selenium.WebDriver;

public class Objectfile {
    public WebDriver driver;
    public   LoginPage loginPage;
    public Homepage home;
    public AddEmployePage addEmployePage;
    public EmployeeListPage employeeListPage;

    public Objectfile(WebDriver driver)
    {
        this.driver=driver;
    }


   public   LoginPage getLoginPage()
    {
    loginPage = new LoginPage(driver);
    return loginPage;

    }


    public AddEmployePage getAddEmployePage()
    {
    addEmployePage = new AddEmployePage(driver);
    return addEmployePage;

    }

    public Homepage getHomePage() {
       home= new Homepage(driver);
       return home;
    }

    public EmployeeListPage  getEmployeeListPage()
    {
        employeeListPage = new EmployeeListPage(driver);
        return employeeListPage;
    }

}
