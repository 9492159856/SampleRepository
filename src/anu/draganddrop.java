package anu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class draganddrop {
WebDriver d;
@BeforeMethod
public void setup()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.MILLISECONDS);
	
	}
@Test
public void test1()
{
d.get("http://jqueryui.com/droppable/");
d.switchTo().frame(d.findElement(By.tagName("iframe")));
Actions a=new Actions(d);
WebElement ff=d.findElement(By.id("draggable"));
WebElement gg=d.findElement(By.id("droppable"));
a.dragAndDrop(ff,gg).perform();
}
@AfterMethod
public void teardown()
{
	d.quit();
	}
}
