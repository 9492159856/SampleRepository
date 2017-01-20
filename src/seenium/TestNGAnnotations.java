package seenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGAnnotations {
WebDriver d;
@BeforeSuite
public void abc()
{
	d=new FirefoxDriver();
}
@AfterSuite
public void abc1()
{
	System.out.println("@AfterSuite");
}
@BeforeClass
public void abc2()
{
	System.out.println("@BeforeClass");
}
@AfterClass
public void abc3()
{
	System.out.println("@AfterClass");
}
@BeforeMethod
public void abc4()
{
	System.out.println("@BeforeMethod");
}
@AfterMethod
public void abc5()
{
	System.out.println("@AfterMethod");
}
@Test
public void abc6()
{
	d.get("http://www.seleniumhq.org/");
	d.findElement(By.linkText("Documentation")).click();
	d.findElement(By.id("java")).click();
}
@Test
public void abc7() throws InterruptedException
{
	d.findElement(By.linkText("introduction")).click();
	Thread.sleep(4000);
	d.close();
}
}

