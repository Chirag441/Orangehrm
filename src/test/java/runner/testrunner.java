package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/FeatureFile" ,glue = "StepDefination",tags = "@chirag"
, monochrome = true)
public class testrunner extends AbstractTestNGCucumberTests {


}
