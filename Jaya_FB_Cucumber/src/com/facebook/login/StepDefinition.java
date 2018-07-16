package com.facebook.login;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;







import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;

public class StepDefinition {
	WebDriver driver;
	String text;
	
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
	}
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Given("^I go to URL$")
	public void I_go_to_URL(){
		driver.navigate().to("https://www.facebook.com");
	}
	@And("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void I_enter_as(String locator,String data){
		driver.findElement(By.id(locator)).sendKeys(data);
	}
	@And("^click on \"([^\"]*)\"$")
	public void click_on(String locator){
		driver.findElement(By.id(locator)).click();
	}
	@Then("^inbox page is displayed$")
	public void inbox_page_is_displayed(){
		List<WebElement> li= driver.findElements(By.cssSelector("div[id='mainContainer']"));
		if (li.size()==0){
			System.out.println("Inbox not displayed");
		}else{
			System.out.println("Inbox displyed");
		}
	}
}

