package cucumRunner1;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import restassured.CucumberTesting;
import restassured.login;
import testsuite001.test;
import testsuite002.pet;

@RunWith(Suite.class)
@Suite.SuiteClasses({CucumberTesting.class})
@CucumberOptions(
        monochrome = true,
        features = {"src/main/java/feactureFolder/cucum.feature"},
        plugin = {"pretty", "html:target/cucumber-reports/executionResult.html"},
        publish = true
        //tags = "@Regression"
)
public class cucumRun1 {
}
