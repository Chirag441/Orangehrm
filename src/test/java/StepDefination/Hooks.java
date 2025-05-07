package StepDefination;

import Utlilies.Basecontext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

    Basecontext base;

    public Hooks(Basecontext base) {
        this.base = base;

    }

    @Before
    public void setDriver() {

        base.setup();

    }

    @After
    public void closeDriver() {
        base.quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario)
    {
        if(scenario.isFailed())
        {
                scenario.attach(base.genric.getScreenshot(),"image/png","image");
        }
    }
}