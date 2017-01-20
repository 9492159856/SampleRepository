package Events;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserSlider {
WebDriver d;
@Test()
public void abc() throws Exception
{
	d.get("http://www.seleniumhq.org/download/");
	Assert.assertEquals("Downloads",d.getTitle());
	//Following is the code that scrolls through the page
	((RemoteWebDriver) d).executeScript("window.scrollBy(0,300)");
	d.findElement(By.linkText("Javadoc")).click();
	 Thread.sleep(1000);
}
@BeforeMethod
public void startup()
{
d=new FirefoxDriver();
d.manage().window().maximize();
d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterMethod
public void cde()
{
d.close();
}
}
