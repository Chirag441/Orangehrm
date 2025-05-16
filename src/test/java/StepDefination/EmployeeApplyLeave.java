package StepDefination;

import PageObjects.EmployeeApplyLeavePage;
import Utlilies.Basecontext;
import io.cucumber.java.en.Then;

public class EmployeeApplyLeave {
    Basecontext base;
    EmployeeApplyLeavePage employeeApplyLeavePage;

    public EmployeeApplyLeave(Basecontext base)
    {
        this.base =base;
        employeeApplyLeavePage = base.objectfile.getEmployeeApplyLeavePage();
        employeeApplyLeavePage.setValues(base);
    }

    @Then("Apply for the leave")
    public void apply_For_The_Leave()
    {
        employeeApplyLeavePage.SwitchToApply();
        employeeApplyLeavePage.applyLeave();
    }

}
