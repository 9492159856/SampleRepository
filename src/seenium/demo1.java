package seenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class demo1 {
	WebDriver d;
	@Test
	public void testdemo()
	{
		d.get("https://my.naukri.com/account/createaccount?othersrcp=23531&wExp=N&gclid=CKjN29Du5tACFY4EaAoddjICrQ");
		Assert.assertEquals("Register on Naukri.com: Apply to Millions of Jobs Online",d.getTitle());
		d.findElement(By.name("userType")).click();
		
		
	}
	@BeforeMethod()
	public void setUp()
	{
		d=new FirefoxDriver();
		d.manage().window().maximize();
		 d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	@AfterMethod()
	public void tearDown()
	{
		d.close();
	}

}
