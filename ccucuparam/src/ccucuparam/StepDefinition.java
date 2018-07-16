package ccucuparam;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class StepDefinition {
	WebDriver driver;
	String text;
	
	@Given("^URL is loaded successfully$")
	public void setUp() {
	    System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
	    driver=new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://apps.qa2qe.cognizant.e-box.co.in/shippingDetails/");
	}

	@When("^page loads check for shipping details tag and \"([^\"]*)\" as link and click the link$")
	public void testShippingDetails(String shipmentId){
	    text=driver.findElement(By.tagName("h2")).getText();
	    Assert.assertEquals("Shipping Details", text.trim());
	    
	    text=driver.findElement(By.linkText(shipmentId)).getTagName();
	    Assert.assertEquals("a", text.trim());
	    
	    driver.findElement(By.linkText(shipmentId)).click();
	    
	    Assert.assertEquals(true, driver.findElement(By.id("result")).isDisplayed());
	    
	}

	@Then("^validate \"([^\"]*)\" is displayed on page$")
	public void validateResult(String custName) {
	    text=driver.findElement(By.xpath("//*[@id='result']//tr[2]/td[1]")).getText();
	    Assert.assertEquals(custName, text.trim());
	    driver.quit();
	}

}
