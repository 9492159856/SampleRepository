package seenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JunitAnnotationsDemo {
	WebDriver d;
@Before
public void abc()
{
	d=new FirefoxDriver();	
}
@Test
public void cde() throws InterruptedException
{
	d.get("http://www.flipcart.com/");
	d.findElement(By.className("LM6RPg")).sendKeys("Books");
	d.findElement(By.className("vh79eN")).click();
	Thread.sleep(5000);
	d.close();
}
}