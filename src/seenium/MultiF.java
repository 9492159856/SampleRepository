package seenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultiF {
	WebDriver d;
	@BeforeTest
	public void suite()
	{
		d=new FirefoxDriver();
	}
	@Test
	public void test() throws Exception
	{
		d.get("http://jqueryui.com/");
		assertEquals("Autocomplete | jQuery UI",d.getTitle());
		List<WebElement> f=d.findElements(By.tagName("iframe"));
		System.out.println("No of frames is"+f.size());
	d.findElement(By.linkText("Autocomplete")).click();
d.switchTo().frame(d.findElement(By.className("demo-frame")));
d.findElement(By.id("tags")).sendKeys("selenium");
d.switchTo().defaultContent();
d.findElement(By.linkText("Button")).click();
Thread.sleep(4000);		
}
	private void assertEquals(String string, String title) {
		// TODO Auto-generated method stub
		d.close();
	}
}
