package Events;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class New {
		WebDriver d;
		@Test
		public void abc() throws Exception
		{
		//Load web page
			d.get("https://www.google.co.in/");
			Assert.assertEquals("Google",d.getTitle());
			WebElement link1=d.findElement(By.linkText("Gmail"));
			Actions a=new Actions(d);
			a.moveToElement(link1).keyDown(Keys.CONTROL).click(link1).build().perform();
			Thread.sleep(2000);
	        d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	        Thread.sleep(3000);
	        d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	        Thread.sleep(3000);

		}
		@BeforeMethod
		public void setUp()
		{
			// Launch browser
			d=new FirefoxDriver();
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
