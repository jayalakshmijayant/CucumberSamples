package cucudatatables;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class StepDefinition {
	WebDriver driver;
	String text;
	
	@Given("^the URL is loaded successfully to launch applcation$")
	public void  setUp() {
	   
	   System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
	   driver= new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.get("http://apps.qa2qe.cognizant.e-box.co.in/Handling_Reg_Expression");
	}

	@When("^I enter \"([^\"]*)\" and click search button$")
	public void testUserDetails(String custName) {
	    
	    driver.findElement(By.id("userId")).sendKeys(custName);
	    driver.findElement(By.id("track")).click();
	}

	@Then("^following details should be displayed$")
	public void validateResult(DataTable custDetails) {
		text=driver.findElement(By.id("result")).getText();
	    Assert.assertEquals(true, text.contains(custDetails.raw().get(0).get(0)+" : "+custDetails.raw().get(1).get(0)));
	    Assert.assertEquals(true, text.contains(custDetails.raw().get(0).get(1)+" : "+custDetails.raw().get(1).get(1)));
	    Assert.assertEquals(true, text.contains(custDetails.raw().get(0).get(2)+" : "+custDetails.raw().get(1).get(2)));
	    Assert.assertEquals(true, text.contains(custDetails.raw().get(0).get(3)+": "+custDetails.raw().get(1).get(3)));
	    driver.quit();
	}
}
