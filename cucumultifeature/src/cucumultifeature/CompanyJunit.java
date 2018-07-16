package cucumultifeature;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
	features={"Features/"},
	glue={"StepDefinitions"})
public class CompanyJunit {

}


