package seenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JunitAnnoDemo {
	WebDriver d;
	@Before
	public void setUp()
	{
		d=new FirefoxDriver();
		System.out.println("@Before");
	}
	@After
	public void tearDown()
	{
		System.out.println("@After");
	}
	@BeforeClass
	public static void oneTimeSetUp()
	{
		System.out.println("@BeforeClass");
	}
	@AfterClass
	public static void oneTimeTearDown()
	{
		System.out.println("@AfterClass");
	}
	@Test
	public void testMeth1()
	{
		System.out.println("@Test1");
	}
	@Test
	public void testMeth2() throws InterruptedException
	{
		d.get("http://www.gmail.com/");
		d.findElement(By.id("Email")).clear();
		d.findElement(By.id("Email")).sendKeys("selenium123@gmail.com");
		d.findElement(By.id("next")).click();
		d.findElement(By.name("Passwd")).clear();
		d.findElement(By.name("Passwd")).sendKeys("12345678");
		d.findElement(By.id("signIn")).click();
		Thread.sleep(4000);
		d.close();
	}	
}
