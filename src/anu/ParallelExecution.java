package anu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelExecution {
WebDriver d;
@Test
public void test1()
{
	//First session of WebDriver
	//System.setProperty("webdriver.chrome.driver","F:\\root\\lib\\chromedriver.exe");
	d=new FirefoxDriver();
	//Goto guru99 site
    d.get("http://demo.guru99.com/V4/");
    //find user name text box and fill it
    d.findElement(By.name("uid")).sendKeys("anusha");
}
public void test2()
{
	d=new FirefoxDriver();
	//Goto guru99 site
    d.get("http://demo.guru99.com/V4/");
    //find user name text box and fill it
    d.findElement(By.name("uid")).sendKeys("srinath");	
}
public void test3()
{
	d=new FirefoxDriver();
	//Goto guru99 site
    d.get("http://demo.guru99.com/V4/");
    //find user name text box and fill it
    d.findElement(By.name("uid")).sendKeys("kksa");	
}

@BeforeMethod
public void setUp()
{
	
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
}
@AfterMethod
public void tearDown()
{
d.close();	
}
}
