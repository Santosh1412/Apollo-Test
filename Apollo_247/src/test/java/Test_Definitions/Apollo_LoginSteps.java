package Test_Definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import POM.PageModel;

public class Apollo_LoginSteps {
	
	String baseUrl = "https://www.apollo247.com/";
	WebDriver driver;
	PageModel pom;
	@Before
	public void launch() throws InterruptedException 
	{
		FirefoxOptions options = new FirefoxOptions();
	    options.addArguments("--disable-notifications");
	    
		System.setProperty("webdriver.gecko.driver", "E:/Selenium//Drivers/geckodriver.exe");
		driver = new FirefoxDriver(options);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	    pom=new PageModel(driver);
	    	      
	}

	
	@Given("Login to the website")
	public void open_the_website() 
	{
		pom.loginIcon();
	    System.out.println("Login screen displayed");
	}
		
	    
	@Given("enter valid mobile number")
	public void enter_valid_mobile_number() 
	{ 
		pom.enterMobileNumber();
		System.out.println("pom"+pom); 
		
	}

	@Given("click on Generate OTP")
	public void click_on_Generate_OTP() throws InterruptedException
	{
		pom.proceedIcon();
	    Thread.sleep(20000);
	    pom.proceedIcon();
	    Thread.sleep(5000);
	    System.out.println("pom"+pom);
	    
	}

	@When("login successful it should show your name")
	public void login_successful_it_should_show_your_name() 
	{
		System.out.println("pom"+pom);
		
	}
	
	//2nd
	@Given("enter Invalid Mobile Number")
	public void enter_Invalid_Mobile_Number() 
	{
	    pom.enterInvalidMobileNumber();
	    
	}

	@Given("user cannot click on Generate OTP")
	public void user_cannot_click_on_Generate_OTP()
	{
		boolean eleSelected= driver.findElement(By.xpath("//div[text()='This seems like a wrong number']")).isDisplayed();
		System.out.println(eleSelected);
		
	    
	}

	@Then("user is still on home page")
	public void user_is_still_on_home_page() 
	{
		driver.getTitle();
	    
	}
	
	
}















