package StepDefination;

import PageObjects.EntitlementsPage;
import Utlilies.Basecontext;
import Utlilies.Genricutils;
import io.cucumber.java.en.And;

public class Entitlements {

    Basecontext base;
    EntitlementsPage entitlementsPage;
    Genricutils genricutils;

    public Entitlements(Basecontext base)
    {
        this.base =base;
        entitlementsPage = base.objectfile.getEntitlementsPage();
        genricutils = base.genric;
        entitlementsPage.setGenricutils(genricutils);
    }




    @And("Add Leaves to Employee")
    public void addLeave()
    {
        entitlementsPage.switchToEntitlements();
        entitlementsPage.employeeLeaveDetails();
    }

}
