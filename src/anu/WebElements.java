package anu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElements {
WebDriver d;
@Test
public void test() throws Exception
{
	d.get("http://www.facebook.com");
	Assert.assertEquals("Facebook - Log In or Sign Up",d.getTitle());
	d.findElement(By.name("firstname")).sendKeys("srinath");
	d.findElement(By.name("lastname")).sendKeys(".b");
	d.findElement(By.name("reg_email__")).sendKeys("srinath.b@gmail.com");
d.findElement(By.name("reg_email_confirmation__")).sendKeys("srinath.b@gmail.com");
	d.findElement(By.name("reg_passwd__")).sendKeys("7366567550");
	Select dd=new Select(d.findElement(By.id("day")));
	dd.selectByIndex(8);
	Select df=new Select(d.findElement(By.id("month")));
	df.selectByIndex(8);
	Select ff=new Select(d.findElement(By.id("year")));
	ff.selectByIndex(19);
	WebElement radio=d.findElement(By.name("sex"));
	if(radio.isSelected())
	{
		System.out.println("Radio button is already selected");
	}
	else
	{
		radio.click();
	}
	Thread.sleep(4000);
}
@BeforeMethod
public void setUp()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}
@AfterMethod
public void tear()
{
	d.close();
}
}
