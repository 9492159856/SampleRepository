package Events;

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

public class LinksDemo {
WebDriver d;
@Test()
public void test()
{
	d.get("http://docs.seleniumhq.org/");
	Assert.assertEquals("Selenium - Web Browser Automation",d.getTitle());
	List<WebElement> l=d.findElements(By.tagName("body"));
	System.out.println(+l.size());
	String links[]=new String[l.size()];
	int i = 0;
	for(WebElement a:l)
	{
		System.out.println(a.getText());
		links[i]=a.getText();
		i++;
	}
	
}
@BeforeMethod()
public void setUp()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterMethod()
public void tearDown()
{
	d.close();
}
}
