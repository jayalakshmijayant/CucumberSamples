package StepDefinitions;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class NodiscountStepDefinition {
	WebDriver driver;
	String text;
	@Given("^the URL is launched successfully$")
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
	    driver= new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://apps.qa2qe.cognizant.e-box.co.in/CompanyOffersDiscount/");
	}

	@When("^I enter weight as (\\d+) and distance as (\\d+) and click submit button$")
	public void testNodiscount(int strWeight, int strDistance) {
		driver.findElement(By.id("weight")).sendKeys(String.valueOf(strWeight));
	    driver.findElement(By.id("distance")).sendKeys(String.valueOf(strDistance));
	    driver.findElement(By.id("submit")).click();
	}

	@Then("^the following text should be displayed$")
	
	public void validateResult(DataTable strText) {
		text=driver.findElement(By.id("result")).getText();
	    Assert.assertEquals(strText.raw().get(1).get(0), text);
	    driver.quit();
	}
}
