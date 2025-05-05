package StepDefination;

import PageObjects.EmployeeListPage;
import Utlilies.Basecontext;
import Utlilies.Genricutils;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class EmployeeList {
    Basecontext base;
    EmployeeListPage employeeListPage;
    boolean status;
    int id = 1012;
    Genricutils genricutils;

    public EmployeeList(Basecontext base) {
        this.base = base;
        employeeListPage = base.objectfile.getEmployeeListPage();
        employeeListPage.setGenricutils(base.genric);
    }

    @And("Verify the employee")
    public void verifyTheEmployee()
    {
     Assert.assertTrue(employeeListPage.searchEmployee(id));

    }
@And("Delete the Employee")
    public void deleteTheEmployee()
    {
     employeeListPage.deleteEmployee();

        Assert.assertFalse(employeeListPage.searchEmployee(id));

    }
}
