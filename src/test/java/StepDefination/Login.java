package StepDefination;

import PageObjects.LoginPage;
import Utlilies.Basecontext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Login {
    Basecontext base;
    LoginPage loginPage;

    public Login(Basecontext base) {
        this.base = base;
        loginPage = base.objectfile.getLoginPage();

    }

    @Given("User Is on login Page")
    public void User_is_on_Login_Page() {

        loginPage.setGenricutils(base.genric);
    }

    @When("login As Admin")
    public void Login_to_home_page() {
        loginPage.loginAsAdmin(loginPage.getUserName(), loginPage.getPassword());
    }

    @And("Login as user")
    public void userLogin() {
        loginPage.loginAsUser();
    }

}
