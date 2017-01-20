package anusha;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class WriteDataXsl {
WebDriver d;
@BeforeSuite()
public void abc()
{
	d=new FirefoxDriver();
}
@Test()
public void cde() throws Exception
{
	d.get("http://www.google.com");
	assertEquals("Google",d.getTitle());
	// Maximize window
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	FileOutputStream fos=new FileOutputStream("G:\\Selenium\\Book2.xls");
	WritableWorkbook wwb=Workbook.createWorkbook(fos);
	WritableSheet ws=wwb.createSheet("Results1",0);
	Label l1=new Label(0,0,"Selenium");
	ws.addCell(l1);
	Label l2=new Label(0,0,"Appium");
	ws.addCell(l2);
	wwb.write();
	Thread.sleep(4000);
	wwb.close();
	
}
private void assertEquals(String string, String title) {
	
}
} 
