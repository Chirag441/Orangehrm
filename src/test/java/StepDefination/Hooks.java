package StepDefination;

import PageObjects.Homepage;
import Utlilies.Basecontext;
import Utlilies.Genricutils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class Hooks {

    Basecontext base;

    public Hooks (Basecontext base) {
        this.base = base;

    }
    @Before
    public void setDriver()
    {

        base.setup();

    }

    @After
    public void closeDriver()
    {
        base.quit();
    }
}