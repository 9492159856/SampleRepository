package Events;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoComplete {
WebDriver d;
@Test
public void abc() throws Exception
{
	d.get("http://jqueryui.com/autocomplete/");
	Assert.assertEquals("Autocomplete | jQuery UI",d.getTitle());
	//Switch driver focus to frame
	d.switchTo().frame(0);
	d.findElement(By.id("tags")).sendKeys("a");
	List<WebElement> s=d.findElements(By.className("ui-menu-item"));
	System.out.println("No of suggestions are:"+s.size());
	System.out.println("******* Suggestions are *********");
	for(WebElement e:s)
	{
		System.out.println(e.getText());
	}
	if(s.size()>=4)
	{
		for(int i=0;i<4;i++)
		{
	d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	}
	d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
	}
	Thread.sleep(4000);
	
}
@BeforeMethod()
public void cde()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterMethod()
public void efg()
{
	d.close();
}
}
