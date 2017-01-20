package seenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultiFrames {
	WebDriver d;
	@BeforeTest
	public void suite()
	{
		d=new FirefoxDriver();
	}
	@Test
	public void test() throws Exception
	{
		d.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
	 List<WebElement> f=d.findElements(By.tagName("frame"));
	System.out.println("No of frames is:"+f.size());
	 for(WebElement e:f)
	 {
		 System.out.println(e.getText());
	 }
	 d.switchTo().frame(0);
	 d.findElement(By.linkText("com.thoughtworks.selenium")).click();
	 d.switchTo().defaultContent();
	 d.switchTo().frame(1);
	 d.findElement(By.linkText("BrowserConfigurationOptions")).click();
	d.switchTo().defaultContent();
	d.switchTo().frame(2);
	d.findElement(By.linkText("Constr")).click();
	d.switchTo().defaultContent();
	 Thread.sleep(4000);
}
	private void assertEquals(String string, String title)
	{
		d.close();
	}
}