package StepDefinitions;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;



public class DiscountStepDefinition {
	WebDriver driver;
	String text;
	
	/*@Given("^the app \"([^\"]*)\" is launched successfully$")
	public void the_app_is_launched_successfully(String url) {
		//System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
	    //driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("google.com");
	    
	}*/
	
	@Given("^the following app is launched successfully$")
	public void the_following_app_is_launched_successfully(DataTable url) {
		System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
	    driver=new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get(url.raw().get(1).get(0));
	}
	
	
	@When("^I enter weight as \"([^\"]*)\" and distance as \"([^\"]*)\" and select submit button$")
	public void testDiscount(String strWeight, String strDistance) {
	    driver.findElement(By.id("weight")).sendKeys(strWeight);
	    driver.findElement(By.id("distance")).sendKeys(strDistance);
	    driver.findElement(By.id("submit")).click();
	    
	}

	@Then("^the text \"([^\"]*)\" should be displayed$")
	public void validateResult(String strText) {
	    text=driver.findElement(By.id("result")).getText();
	    Assert.assertEquals(strText, text);
	    driver.quit();
	}
}
