package anusha;

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


public class Web {
WebDriver d;
@Test
public void test() throws InterruptedException
{
	d.get("http://aponline.gov.in/apportal/contact/sec_select.asp?sid=1");
	Assert.assertEquals(":: Government Orders ::",d.getTitle());
	Select dd=new Select(d.findElement(By.id("Select1")));
	dd.selectByIndex(1);
 List<WebElement> tr_Collection=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr"));
 System.out.println("Number of rows in this table"+tr_Collection.size());
 List<WebElement> td_Collection=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr/td"));
System.out.println("Number of Columns in this table"+td_Collection.size()/tr_Collection.size());
	int row_num,col_num;
	row_num=1;
	for(WebElement trElement:tr_Collection)
	{
	List<WebElement> td_Collection1=trElement.findElements(By.xpath("td"));	
	//System.out.println("Number of Columns"+row_num+" "+td_Collection.size());
	col_num=1;
	for(WebElement tdElement:td_Collection)
	{
		System.out.println("Row * "+row_num+", Col * "+col_num+",Text="+tdElement.getText());
	}
	row_num++;
	}
	Thread.sleep(4000);
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

