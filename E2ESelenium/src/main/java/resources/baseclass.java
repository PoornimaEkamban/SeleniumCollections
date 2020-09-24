package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class baseclass 
{
	public static WebDriver driver;
	public Properties prop;
	public String url;
	public WebDriver intializeDriver() throws IOException
	{
		prop=new Properties();
		FileInputStream fis =new FileInputStream("D:\\Poornima\\EndtoEndSeleniumFramework\\E2ESelenium\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		url=prop.getProperty("url");
		
		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:/Poornima/SeleniumDriver/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:/Poornima/SeleniumDriver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browsername.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver","D:/Poornima/SeleniumDriver/chromedriver.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public void takeScreenshot(String testMethodName, WebDriver driver) 
	{
		String screenName= System.currentTimeMillis()+ ".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileHandler.copy(src, new File(System.getProperty("user.dir")+"/target/Screenshots/"+screenName+""));
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
