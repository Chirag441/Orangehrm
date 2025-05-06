package StepDefination;

import Utlilies.Basecontext;
import io.cucumber.java.After;
import io.cucumber.java.Before;


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
}