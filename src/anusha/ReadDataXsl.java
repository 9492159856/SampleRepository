package anusha;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadDataXsl {
WebDriver d;
@BeforeSuite()
public void read()
{
	d=new FirefoxDriver();
}
@Test()
public void data() throws BiffException, IOException, InterruptedException
{
	d.get("http://www.google.com/");
	assertEquals("Google",d.getTitle());
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	//Read data from excel using JXL
	FileInputStream fis=new FileInputStream("G:\\Selenium\\Book1.xls");
	Workbook wb=Workbook.getWorkbook(fis);
	Sheet s=wb.getSheet(0);
	for(int i=0;i<s.getRows();i++)
	{
		d.findElement(By.id("lst-ib")).clear();
		d.findElement(By.id("lst-ib")).sendKeys(s.getCell(0,i).getContents());
		Thread.sleep(4000);
	}
	
}
private void assertEquals(String string, String title) {
d.close();
	
}
}
