package anu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class link {
WebDriver d;
@Test
public void test()
{
	d.get("http://docs.seleniumhq.org/");
	Assert.assertEquals("Selenium - Web Browser Automation",d.getTitle());
	List<WebElement> link=d.findElements(By.xpath("//li[starts-with(@id,'menu')]"));
	System.out.print("Number of links in this webpage"+link.size());
	System.out.println("\n");
	System.out.println("***** Links are ******");
	String links[]=new String[link.size()];
	int i=0;
	for(WebElement e:link)
	{
		System.out.println(e.getText());
		links[i]=e.getText();
		i++;
	}
	for(String t:links)
	{
		
		d.findElement(By.linkText(t)).click();
		if(d.getTitle().contains("404"))
		{
			System.out.println("Link:"+t+" is not woking ");
		}
		else
		{
			System.out.println("Link:"+t+" is woking fine ");
		}
	}
	
}
@BeforeMethod
public void setUp()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterMethod
public void tearDown()
{
	//d.close();
}
}
