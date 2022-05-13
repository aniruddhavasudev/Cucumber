package Steps;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver = new ChromeDriver(); 

	@Given("^User is already on login page$")
	public void user_is_already_on_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.get("https://ui.freecrm.com/");
	}

	@SuppressWarnings("deprecation")
	@When("^Title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String title =  driver.getTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}

	@Then("^User enters Username$")
	public void user_enters_Username() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@name,'email')]")).sendKeys("aniruddha1794@gmail.com");
	}

	@Then("^User enters password$")
	public void user_enters_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[contains(@name,'password')]")).sendKeys("Taurus1994");
	}

	@Then("^User clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[contains(@class,'ui fluid large blue submit button')]")).click();
	}

	@Then("^User adds the following contacts$")
	public void user_adds_the_following_contact(DataTable contacts) throws Throwable{
		for(Map<String, String> data : contacts.asMaps()) {
			Actions action = new Actions(driver);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement we = driver.findElement(By.xpath("//*[@id='main-nav']/div[3]"));
			action.moveToElement(we).build().perform();
			action.pause(5000);
			driver.findElement(By.xpath("//*[contains(@id,'main-nav')]/child::div[3]/child::button")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.navigate().refresh();
			driver.findElement(By.xpath("//*[contains(@name,'first_name')]")).sendKeys(data.get("firstname"));
			driver.findElement(By.xpath("//*[contains(@name,'last_name')]")).sendKeys(data.get("lastname"));
			driver.findElement(By.xpath("//*[contains(@class,'ui linkedin button')]")).click();
		}
		
}
}
