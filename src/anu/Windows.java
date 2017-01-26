package anu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Windows {
WebDriver d;
@Test
public void test()
{
	d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	Assert.assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
	d.findElement(By.xpath("//div[@id='demon_content']/div[2]/input")).click();
	d.findElement(By.xpath("//*[@id='bluemenu']/ul/li[1]/a/span[2]/font")).click();
	//d.findElement(By.linkText("Food-on-Track")).click();
	d.findElement(By.xpath("//*[@id='middle']/div/div/a/img")).click();
}
@BeforeMethod
public void setUp()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);	
}
@AfterMethod
public void tearDown()
{
	d.close();
}
}