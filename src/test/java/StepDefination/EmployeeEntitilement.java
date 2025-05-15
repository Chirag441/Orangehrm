package StepDefination;

import PageObjects.EmployeeEntitlementsPage;
import Utlilies.Basecontext;
import io.cucumber.java.en.And;

public class EmployeeEntitilement {
    Basecontext base;
    EmployeeEntitlementsPage employeeEntitlementsPage;
    public EmployeeEntitilement(Basecontext base)
    {
        this.base =base;
        employeeEntitlementsPage = base.objectfile.getEmployeeEntitlementsPage();
        employeeEntitlementsPage.setGenricutils(base.genric);
    }

    @And("Verify the employee Leave Details")
    public  void verify_The_Employee_Leave_Details()
    {
        employeeEntitlementsPage.switchToEntitilement();
        employeeEntitlementsPage.VerifyLeave();
    }
}
