package anusha;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ReadDataOldToNewExcelSheet {
WebDriver d;
private Object uname;
private String password;
@BeforeSuite()
public void abc()
{
	d=new FirefoxDriver();
}
@Test()
public void cde() throws JXLException, IOException, Exception
{
d.get("http://www.google.com/");
assertEquals("Google",d.getTitle());
d.manage().window().maximize();
d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
FileOutputStream fos=new FileOutputStream("G:\\Selenium\\Book3.xls");
WritableWorkbook wwb=Workbook.createWorkbook(fos);
WritableSheet ws=wwb.createSheet("Result1",0);
Label l1=new Label(0,0,"uname");
ws.addCell(l1);
Label l2=new Label(1,0,"password");
ws.addCell(l2);
Label l3=new Label(0,1,"anusha");
ws.addCell(l3);
Label l4=new Label(1,1,"12345678");
ws.addCell(l4);
Label l5=new Label(0,2,"srinath");
ws.addCell(l5);
Label l6=new Label(1,2,"anu12345");
ws.addCell(l6);
wwb.write();
FileOutputStream fos1=new FileOutputStream("G:\\Selenium\\Book4.xls");
WritableWorkbook wwb1=Workbook.createWorkbook(fos);
WritableSheet ws1=wwb.createSheet("Result1",0);
for(int i=0;i<ws.getRows();i++)
{
	for(int j=0;j<ws.getColumns();j++)
	{
		Label l=new Label(j,i,ws.getCell(j,i).getContents());
		ws.addCell(l);
	}
}
wwb.write();
Thread.sleep(4000);
wwb.close();
}
private void assertEquals(String string, String title) {
}
}

