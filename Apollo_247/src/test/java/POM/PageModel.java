package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageModel {
	@CacheLookup
	@FindBy(id = "loginPopup") WebElement Login_Icon;
	@FindBy(name = "mobileNumber") WebElement mobile_Input_Field;
	@FindBy(className = "icon-ic_arrow_forward") WebElement proceed_icon;
	@FindBy(className = "//input[@type=\\'tel\\']") WebElement otp_input_field;
	@FindBy(xpath = "\"/html/body/div[3]/div[3]/div/div/div/form/div[1]/div[2]\"") WebElement Error_message;
	
	WebDriver driver;

	public PageModel(WebDriver driver) 
	{
		super();
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void loginIcon()
	{
		Login_Icon.click();
	}
	
	public void enterMobileNumber() 
	{
		mobile_Input_Field.sendKeys("8886890682");
	}
	
	public void proceedIcon() 
	{
		proceed_icon.click();
	}
	
	public void otpField()
	{
		otp_input_field.click();
	}
	
	public void enterInvalidMobileNumber() 
	{
		mobile_Input_Field.sendKeys("1236458");
	}
	
}