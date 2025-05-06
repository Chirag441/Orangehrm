package StepDefination;

import PageObjects.AddEmployePage;
import Utlilies.Basecontext;
import Utlilies.Genricutils;
import io.cucumber.java.en.And;

public class AddEmploye {
    AddEmployePage addEmployePage;
    Basecontext base;
    Genricutils genricutils;

    public AddEmploye(Basecontext base) {
        this.base = base;
        this.addEmployePage = base.objectfile.getAddEmployePage();
        genricutils = base.genric;
        addEmployePage.setGenricutils(genricutils);
    }

    @And("add the Employe")
    public void newEmployee() {
        genricutils.loadExcelFile();
        addEmployePage.createEmployee();


    }
}
