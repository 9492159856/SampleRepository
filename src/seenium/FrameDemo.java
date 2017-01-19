package seenium;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameDemo {
WebDriver d;
@BeforeTest
public void suite()
{
	d=new FirefoxDriver();
}
@Test
public void test() throws Exception
{
	d.get("http://jqueryui.com/autocomplete/");
	assertEquals("Autocomplete | jQuery UI",d.getTitle());
	List<WebElement> f=d.findElements(By.tagName("iframe"));
	//switch to the inside frame
	d.switchTo().frame(d.findElement(By.className("demo-frame")));
	//type the text
	d.findElement(By.id("tags")).sendKeys("selenium");
	d.switchTo().defaultContent();
	d.findElement(By.linkText("Button")).click();
	Thread.sleep(4000);
}
private void assertEquals(String string, String title) {
	d.close();
}
}
