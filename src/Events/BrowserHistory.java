package Events;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserHistory {
WebDriver d;
@Test()
public void test() throws Exception
{
	d.get("http://docs.seleniumhq.org/");
	Assert.assertEquals("Selenium - Web Browser Automation",d.getTitle());
	d.findElement(By.linkText("Download")).click();
	Thread.sleep(2000);
	d.navigate().back();
	Thread.sleep(3000);
	d.navigate().forward();
	Thread.sleep(4000);
	d.navigate().refresh();
	Thread.sleep(5000);
}
@BeforeMethod()
public void setUp()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterMethod()
public void down()
{
	d.close();
}
}
