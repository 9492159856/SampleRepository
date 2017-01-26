package seenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Css {
WebDriver d;
@BeforeSuite
public void abc()
{
	d=new FirefoxDriver();
}
@Test
public void cde()
{
	d.get("https://www.facebook.com/");
	d.findElement(By.id("email")).sendKeys("selenium");
}
}
