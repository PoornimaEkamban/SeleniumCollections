package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(css="#SubmitLogin > span")
	WebElement signin;


	@FindBy(css=".alert > p")
	WebElement verify;
	
	public WebElement EmailId()
	{
		return email;
	}

	public WebElement Password()
	{
		return password;
	}
	public WebElement SignIn()
	{
		return signin;
	}
	public WebElement Verify()
	{
		return verify;
	}
}
