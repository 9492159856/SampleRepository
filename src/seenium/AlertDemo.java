package seenium;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class AlertDemo {
WebDriver d;
@BeforeMethod
public void abc()
{
d=new FirefoxDriver();
}
@Test
public void test()
{
d.get("https://www.irctc.co.in/eticketing/loginHome.jsf/");
assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
//d.findElement(By.id("button")).click();
d.findElement(By.xpath("//*[@id='loginbutton']")).click();
Alert al=d.switchTo().alert();
al.accept();
d.findElement(By.id("usernameId")).sendKeys("selenium");
d.findElement(By.xpath("//*[@id='loginbutton']")).click();
al.accept();
}
@Test
public void test1() throws InterruptedException
{
	d.findElement(By.name("j_password")).sendKeys("12345678"); 
	d.findElement(By.xpath("//*[@id='loginbutton']")).click();
	Alert al1=d.switchTo().alert();
	al1.accept();
	d.findElement(By.xpath("//*[@id='loginFormId']/div[1]/div[2]/table[1]/tbody/tr[3]/td[2]/input")).sendKeys("LMM7F");
	d.findElement(By.xpath("//*[@id='loginbutton']")).click();
	Thread.sleep(4000);
}
	@AfterMethod
	public void tearDown()
	{
	d.close();
}
}
