package seenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webdem {
WebDriver d;
@Before
	public void abc()
	{
	 d=new FirefoxDriver();	
	}
@Test
public void xyz() throws InterruptedException
{
		//Load web page
		d.get("https://www.facebook.com/");
		// Maximize window
		d.manage().window().maximize();
		// Enter user name
		d.findElement(By.id("email")).sendKeys("Selenium");
		// Enter password
		d.findElement(By.id("pass")).sendKeys("Selenium");
		// Click on Login button
		d.findElement(By.id("u_0_l")).click();
		//pause 4sec
		Thread.sleep(4000);

	}
	@After
	public void tear()
	{
		d.close();
	}

}

