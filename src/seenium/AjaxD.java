package seenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class AjaxD {
	WebDriver d;
	@Before
	public void abc()
	{
		//Launch browser
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	@Test
	public void testAjax() throws Exception
	{
		//Load web page
		d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
		//Verify page title
		assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India",d.getTitle());
		//Select bank
		Select bank=new Select(d.findElement(By.id("selBank")));
		bank.selectByIndex(4);
		selectOption(d.findElement(By.id("selState")),"Andhra Pradesh");
		selectOption(d.findElement(By.id("selCity")),"Hyderabad");
		selectOption(d.findElement(By.id("selBranch")),"Madhapur");
		/*//Select state
		Select state=new Select(d.findElement(By.id("selState")));
		state.selectByVisibleText("Andhra Pradesh");
		//Select city
		Select city=new Select(d.findElement(By.id("selCity")));
		city.selectByVisibleText("Hyderabad");
		//Select branch
		Select branch=new Select(d.findElement(By.id("selBranch")));
		branch.selectByVisibleText("Madhapur");*/
	}
	public void selectOption(WebElement dd,String option)
	{
		Select s=new Select(dd);
		s.selectByVisibleText(option);	
	}
	
	@After
	public void tvs() throws InterruptedException
	{
		Thread.sleep(4000);
		//Close browser
		d.close();
	}
}
