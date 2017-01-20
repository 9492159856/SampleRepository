package anusha;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class WebTableSingleRow {
WebDriver d;
@Test
public void test() throws InterruptedException
{
	d.get("http://jqueryui.com/datepicker//");
	Assert.assertEquals("Datepicker | jQuery UI",d.getTitle());
	d.switchTo().frame(0);
	d.findElement(By.id("datepicker")).click();
	WebElement dd=d.findElement(By.xpath("//div[@id='ui-datepicker-div']"));
	List<WebElement> trows=dd.findElements(By.tagName("tr"));
	System.out.println("Num of Row this table"+trows.size());
	List<WebElement> tColumns=dd.findElements(By.tagName("td"));
	System.out.println("Num of columns in this table"+tColumns.size());
	for(WebElement tdColumn:tColumns)
	{
		System.out.println(tdColumn.getText());
		if(tdColumn.getText().equals("21"))
		{
			tdColumn.findElement(By.linkText("21")).click();
			Thread.sleep(4000);
		}
	}
}
@BeforeMethod
public void setUp()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterMethod
public void tearDown()
{
	//d.close();
}
}
