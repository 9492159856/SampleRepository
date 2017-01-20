package Events;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SiderDemo {
	WebDriver d;
	@Test
	public void testDragNDrop() throws Exception
	{
		//Load web page
		d.get("http://jqueryui.com/slider/");
		Assert.assertEquals("Slider | jQuery UI",d.getTitle());
		//Switch driver focus to frame
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		a.dragAndDropBy(d.findElement(By.xpath("//div[@id='slider']/span")),400,0).perform();
		Thread.sleep(4000);
}
	@BeforeMethod()
	public void abc()
	{
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@AfterMethod()
	public void cde()
	{
		d.close();
	}
}