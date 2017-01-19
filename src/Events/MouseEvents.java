package Events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MouseEvents {
	WebDriver d;
	@BeforeSuite
	public void abc()
	{
		d=new FirefoxDriver();
	}
	@Test
	public void cde() throws InterruptedException
	{
		d.get("http://jqueryui.com/menu/");
		assertEquals("jQuery UI",d.getTitle());
		//Switch driver focus to frame
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		a.moveToElement(d.findElement(By.id("ui-id-4"))).perform();
		Thread.sleep(2000);
		d.findElement(By.id("ui-id-7")).click();
		Thread.sleep(4000);
		d.close();	
}
	private void assertEquals(String string, String title) {
		// TODO Auto-generated method stub
		
	}
}