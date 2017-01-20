package Events;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class ConfirmationDemo {
WebDriver d;
@Test()
public void test() throws Exception
{
	d.get("http://output.jsbin.com/enifaf");
	d.findElement(By.cssSelector("button")).click();
	//Switch driver focus to confirmation
	Alert al=d.switchTo().alert();
	Assert.assertEquals("Press a button!",al.getText());
	al.dismiss();
	Thread.sleep(4000);	
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
