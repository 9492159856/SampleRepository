package Events;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTab1 {
	WebDriver d;
	@Test
	public void testnewTab() throws Exception
	{
		//Load web page
		d.get("https://www.google.co.in");
		assertEquals("Google",d.getTitle());
		WebElement link1=d.findElement(By.linkText("Gmail"));
		Actions a=new Actions(d);
		//a.moveToElement(link1).keyDown(Keys.CONTROL).click(link1).build().perform();
		a.moveToElement(link1).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(4000);
		d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
		Thread.sleep(4000);
		d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
		Thread.sleep(3000);
	}
	@BeforeMethod
	public void setUp()
	{

		//Launch browser
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\DriverServer\\chromedriver.exe");
		//d=new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "E:\\DriverServer\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		//d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}


}
