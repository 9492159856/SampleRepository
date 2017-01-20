package seenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class INBDemo {
WebDriver d;
@BeforeSuite
public void abc()
{
	d=new FirefoxDriver();
}
@Test
public void cde() throws InterruptedException
{
	d.get("https://www.onlinesbh.com/");
	d.findElement(By.linkText("LOGIN")).click();
	d.findElement(By.linkText("CONTINUE TO LOGIN")).click();
	d.findElement(By.xpath("//*[@id='username']")).sendKeys("selenium");
	d.findElement(By.xpath("//*[@id='label2']")).sendKeys("anu@12sha");
	d.findElement(By.xpath("//*[@id='Button2']")).click();
	Thread.sleep(4000);
	d.close();
}
}
