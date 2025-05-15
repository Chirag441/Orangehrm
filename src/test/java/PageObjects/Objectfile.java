package PageObjects;

import org.openqa.selenium.WebDriver;

public class Objectfile {
     WebDriver driver;
     LoginPage loginPage;
    Homepage home;
    AddEmployePage addEmployePage;
   EmployeeListPage employeeListPage;
   EntitlementsPage entitlementsPage;

   EmployeeEntitlementsPage employeeEntitlementsPage;

    public Objectfile(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage getLoginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;

    }


    public AddEmployePage getAddEmployePage() {
        addEmployePage = new AddEmployePage(driver);
        return addEmployePage;

    }

    public Homepage getHomePage() {
        home = new Homepage(driver);
        return home;
    }

    public EmployeeListPage getEmployeeListPage() {
        if (employeeListPage == null) {
            employeeListPage = new EmployeeListPage(driver);
        }
        return employeeListPage;
    }

    public  EntitlementsPage getEntitlementsPage()
    {
        entitlementsPage =new EntitlementsPage(driver);

        return entitlementsPage;
    }

    public EmployeeEntitlementsPage getEmployeeEntitlementsPage()
    {
        employeeEntitlementsPage = new EmployeeEntitlementsPage(driver);
        return employeeEntitlementsPage;
    }

}
