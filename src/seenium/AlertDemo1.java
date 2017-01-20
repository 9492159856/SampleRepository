package seenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertDemo1 {
	WebDriver d;
@Test
public void testAlert() throws Exception
{
	//Load web page
	d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
	//Click on Login
	d.findElement(By.id("loginbutton")).click();
	//Switch driver focus to alert
	Alert al=d.switchTo().alert();
	//Verify alert text
	assertEquals("Enter User ID",al.getText());
	//Ok
	al.accept();
	//Enter user name
	d.findElement(By.id("usernameId")).sendKeys("Selenium");
	//Click on Login
	d.findElement(By.id("loginbutton")).click();
	//ok
	al.accept();
	//Enter password
	d.findElement(By.name("j_password")).sendKeys("Selenium");
	//Click on Login
	d.findElement(By.id("loginbutton")).click();
	//Ok
	al.accept();
	Thread.sleep(4000);
}
	
	@BeforeMethod
	public void setUp()
	{
		// Launch browser
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","F:\\Driver Server\\chromedriver.exe");
		//d =new ChromeDriver();
		System.setProperty("webdriver.ie.driver","F:\\Driver Server\\IEDriverServer.exe");
		//d = new InternetExplorerDriver();
		 // Maximize window
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown()
	{
	    //  Close browser
		d.quit();
	}

}

