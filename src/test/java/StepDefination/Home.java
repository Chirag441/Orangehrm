package StepDefination;

import PageObjects.Homepage;
import Utlilies.Basecontext;
import Utlilies.Genricutils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Home {
    Basecontext base;
    Homepage homepage;
    Genricutils gernal;

    public Home(Basecontext base) {
        this.base = base;
        homepage = base.objectfile.getHomePage();
        gernal = base.genric;
    }

    @Then("Page Verification")
    public void verify() {
        homepage.Verify();
    }

    @And("Logout the user")
    public void logOutTheUser() {
        homepage.LogOut();

    }

    @Then("Switch to {string} tab")
    public void switchToMenu(String tab) {
        gernal.SideMenu(tab);
    }


//    @Then("Switch to <tab> tab")
//    public void switchToTabTab() {
//    }
}


