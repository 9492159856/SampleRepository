package anu;

import java.util.List;
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

public class locatingElements {
 private WebDriver d;
 private String baseUrl;
 private boolean acceptNextAlert = true;
 private StringBuffer verificationErrors = new StringBuffer();
@Test
public void test() throws Exception
{
	d.get(baseUrl + "/?gfe_rd=cr&ei=8LcWWOGcLtSBoAPwsK7wAg&gws_rd=ssl");
    Assert.assertEquals("Google", d.getTitle());
	d.findElement(By.id("lst-ib")).clear();
	//id
	d.findElement(By.id("lst-ib")).sendKeys("selenium");
	//Name
	//d.findElement(By.name("q")).sendKeys("appium");
	//class name
    //d.findElement(By.className("gsfi")).sendKeys("QTP");
    //Link Text
	d.findElement(By.linkText("Sign in")).click();
	//Partial link text
	d.findElement(By.partialLinkText("Sign")).click();
	//Xpath
	d.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
	//TagName
	List<WebElement> l=d.findElements(By.tagName("a"));
	System.out.println("No of links:"+l.size());
	//d.findElement(By.name("btnG")).click();
	Thread.sleep(4000);
}
@BeforeMethod
public void setUp()
{
	System.setProperty("webdriver.gecko.driver", "F:\\root\\lib\\geckodriver.exe");
	d=new FirefoxDriver();
	baseUrl = "https://www.google.co.in/";
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}
@AfterMethod
public void tear()
{
	//d.close();
}
}
