package Events;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Common {
private static final Object browser = null;
WebDriver d;
@BeforeMethod()
@Parameters("browse")
public void setUp()
{
	//Launch browser
	if(browser.equals("FF"))
	{
	     d=new FirefoxDriver();
	}
	else if(browser.equals("GC"))
			{
		System.setProperty("webdriver.chrome.driver","F:\\root\\lib\\chromedriver.exe");
		d= new ChromeDriver();
			}
	else if(browser.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver","F:\\root\\lib\\IEDriverServer.exe");
		d=new InternetExplorerDriver();
	}
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}

@AfterMethod()
public void tearDown()
{
	d.close();
}
}
