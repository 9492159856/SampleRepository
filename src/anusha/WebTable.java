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

public class WebTable {
WebDriver d;
@Test()
public void tear() throws Exception 
{
	d.get("http://aponline.gov.in/apportal/contact/sec_select.asp?sid=1");
	Assert.assertEquals(":: Government Orders ::",d.getTitle());
	Select s=new Select(d.findElement(By.id("Select1")));
	s.selectByIndex(1);
	List<WebElement> tr_collection= d.findElements(By.xpath("//table[@id='Table9']/tbody/tr"));
	System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
	List<WebElement> td_collection1=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr/td"));
	System.out.println("NUMBER OF COLUMNS IN THIS TABLE="+td_collection1.size()/tr_collection.size());
	int row_num,col_num;
	row_num=1;
	for(WebElement trElement : tr_collection)
    {
		List<WebElement> td_collection=trElement.findElements(By.xpath("td"));

        col_num=1;
        for(WebElement tdElement : td_collection1)
        {
        	System.out.println("Row # "+row_num+", Col # "+col_num  + ", Text=" +tdElement.getText());
            col_num++;
        }
        row_num++;
    }
	Thread.sleep(4000);
    }
@BeforeMethod()
public void tear1()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterMethod()
public void teardown()
{
	d.close();
}
}
