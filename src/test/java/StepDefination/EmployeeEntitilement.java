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

    @And("verify the Leave count added by admin")
    //verify the Leave count added by admin
    public  void verify_The_Leave_Count_Added_By_Admin()
    {
        employeeEntitlementsPage.switchToEntitilement();
        employeeEntitlementsPage.VerifyCount();
    }


}
