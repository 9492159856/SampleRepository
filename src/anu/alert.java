package anu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class alert {
WebDriver d;
@Test
public void test()
{
	d.get("https://www.irctc.co.in/eticketing/loginHome.jsf/");
    Assert.assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
    d.findElement(By.xpath("//*[@id='demon_content']/div[2]/input")).click();
    d.findElement(By.name("j_username")).sendKeys("selenium");
    d.findElement(By.id("loginbutton")).click();
    Alert al=d.switchTo().alert();
    al.accept();
    d.findElement(By.name("j_password")).sendKeys("selenium");
    d.findElement(By.name("submit")).click();
	al.getText();
	System.out.println("Test is:::::"+al.getText());
	//al.accept();
	al.dismiss();
	
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
