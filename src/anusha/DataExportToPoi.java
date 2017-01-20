package anusha;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataExportToPoi {
	WebDriver d;
	@Test()
	public void test() throws IOException, Exception
	{
		//Load web page
				//d.get("https://www.google.co.in");
				//Verify page title
				//Assert.assertEquals("Google",d.getTitle());
				FileOutputStream fos=new FileOutputStream("G:\\Selenium\\anu.xlsx");
				XSSFWorkbook wb=new XSSFWorkbook();
				XSSFSheet sh=wb.createSheet("Result1");
				Row r=sh.createRow(0);
				r.createCell(0).setCellValue("selenium");
				r.createCell(1).setCellValue("Appium");
				wb.write(fos);
				fos.close();
}
	@BeforeMethod
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