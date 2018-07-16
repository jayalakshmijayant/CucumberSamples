

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features = "resources//login.feature",
glue = {"src//LoginTest.java"})
public class Runner1 {

}
