import org.testng.Assert;




import util.TestUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class LoginTest {
TestUtil selenium= new TestUtil();
	
	
	
	
	@Given("^I go to \"([^\"]*)\" on \"([^\"]*)\"$") 
	public void I_goto_Amazon(String url, String browser) throws Exception{
		System.out.println("I navigate to "+ url+ " in the browser "+browser);
		selenium.openBrowser(browser);
		selenium.navigatetoURL(url);
	}
	
	
	@And("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void I_enter(String object,String text){
		System.out.println("I enter in the : "+object+" field, the text : "+text);
		selenium.typeinField(object, text);
		//selenium.typeinField(object, text);
	}
	
	@And("^I click on \"([^\"]*)\"$")
	public void I_click_on(String object){
		System.out.println("Clicked on : "+object);
		selenium.click(object);
	}
	@Then("^login should be \"([^\"]*)\"$")
	public void Then_login_should_be(String result){
		boolean result1=selenium.isElementPresent("leftNavigation_id");
		
		String actualres=null;
		if(result1==true)
			actualres="successful";
		else
			actualres="Failure";
		Assert.assertEquals(actualres, result);
		System.out.println("Login : "+result);
	}
	
}
