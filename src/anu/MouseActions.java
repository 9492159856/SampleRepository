package anu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseActions {
WebDriver d;
@Test
public void test() throws InterruptedException
{
	d.get("http://jqueryui.com/menu/");
	Assert.assertEquals("Menu | jQuery UI",d.getTitle());
	//Switch driver focus to frame
	d.switchTo().frame(0);
	Actions a=new Actions(d);
	a.moveToElement(d.findElement(By.id("ui-id-4"))).perform();
	Thread.sleep(2000);
	d.findElement(By.id("ui-id-7")).click();
	Thread.sleep(3000);	
}
@BeforeMethod
public void setUp()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterMethod
public void tearDown()
{
d.close();
}
}

