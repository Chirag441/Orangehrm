package Utlilies;

import PageObjects.Objectfile;


public class Basecontext {

    public Objectfile objectfile;
    public Genricutils genric;
    public Loaddriver loaddriver;


    public void setup() {
        loaddriver = new Loaddriver();
        objectfile = new Objectfile(loaddriver.getDriver());
        genric = new Genricutils(loaddriver.driver, objectfile);
    }

    public void quit() {
        loaddriver.driver.quit();

    }
}
