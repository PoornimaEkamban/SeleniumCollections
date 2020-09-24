package TP.E2ESelenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.baseclass;

public class ValidateTest extends baseclass
{
	
	@BeforeTest
	public void setup() throws IOException
	{
		driver=intializeDriver();
		driver.get(url);
	}
	
	@Test(dataProvider="getData")
	public void validateTest(String email,String password)
	{	
		
		LandingPage llp=new LandingPage(driver);
		llp.OnlineShopping().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.EmailId().sendKeys(email);
		lp.Password().sendKeys(password);
		lp.SignIn().click(); 
		Assert.assertEquals(lp.Verify().getText(), "There is 1 erro");
		
		
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="sele";
		data[0][1]="seletest";
		return data;
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}
