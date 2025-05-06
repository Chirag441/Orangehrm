package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/FeatureFile" ,glue = "StepDefination",tags = "@chirag"
, monochrome = true, plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class testrunner extends AbstractTestNGCucumberTests {


}
