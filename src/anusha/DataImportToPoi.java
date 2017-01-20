package anusha;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataImportToPoi {
WebDriver d;
@Test()
public void test() throws IOException, Exception
{
	//Load web page
			d.get("https://www.google.co.in");
			//Verify page title
			Assert.assertEquals("Google",d.getTitle());
			FileInputStream fis=new FileInputStream("G:\\Selenium\\sheet1.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh1=wb.getSheetAt(0);
			for(int i=0;i<sh1.getLastRowNum()+1;i++)
			{
			d.findElement(By.id("lst-ib")).clear();
			d.findElement(By.id("lst-ib")).sendKeys(sh1.getRow(i).getCell(0).getStringCellValue());
			}
			Thread.sleep(4000);
}
@BeforeMethod()
public void setUp()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterMethod()
public void abc()
{
	d.close();
}
}
