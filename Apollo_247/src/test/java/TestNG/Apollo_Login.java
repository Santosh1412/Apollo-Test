package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Apollo_Login
{
	String baseUrl = "https://apollo247.com";
	String expectedTitle1 ="Apollo 247 - Online Doctor Consultation & Online Medicines, Apollo Pharmacies Near Me";
	String expectedTitle2 = "Apollo 247 - Online Doctor Consultation & Online Medicines, Apollo Pharmacies Near Me";
	String actualTitle1 = null ;
	String actualTitle2 = null ;
	WebDriver driver;
  @Test(priority = 1)
  public void verifyHomePage() 
  {
	  actualTitle1 =driver.getTitle();
	  Assert.assertEquals(actualTitle1, expectedTitle1);
  }
  @Test(priority = 2)
  public void LoginPage() throws InterruptedException 
  {
	  driver.findElement(By.id("loginPopup")).click();
	  driver.findElement(By.name("mobileNumber")).sendKeys("8886890682");
	  driver.findElement(By.className("icon-ic_arrow_forward")).click();
	  Thread.sleep(15000);
	  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/form/div[1]/div[2]/button")).click();
	  actualTitle2 =driver.getTitle();
	  Assert.assertEquals(actualTitle2, expectedTitle2);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//div[@title='Control profile']")).click();
	  driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/header/div[3]/div[2]/div/div/div/ul/li[8]/a/span/span")).click();
	  Thread.sleep(5000);
  }
  @Test(priority = 3)
  public void InvalidLoginPage() throws InterruptedException  
  {
	  Thread.sleep(5000);
	  driver.findElement(By.id("loginPopup")).click();
	  driver.findElement(By.name("mobileNumber")).sendKeys("1234567890");
	  String message =  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/form/div[1]/div[2]")).getText();
	  System.out.println(message);
  }
  @BeforeTest
  public void Login() throws InterruptedException 
  {
	  FirefoxOptions options = new FirefoxOptions();
	  options.addArguments("--disable-notifications");
	  System.setProperty("webdriver.gecko.driver", "E:/Selenium//Drivers/geckodriver.exe");
	  driver = new FirefoxDriver(options);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);

	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.get(baseUrl);
	  System.out.println("Home screen displayed");
	  
  }

  @AfterTest
  public void Stop() 
  {
	  driver.quit();
  }

}
