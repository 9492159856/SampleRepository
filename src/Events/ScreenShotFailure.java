package Events;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenShotFailure {
WebDriver d;
@Test()
public void test() throws Exception
{
	//d.get("http://www.google.com");
	Assert.assertEquals("Pass",getScreenshot());
	Thread.sleep(4000);
}

private  String getScreenshot() throws IOException {
	try
	{
	d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
	Assert.assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India",d.getTitle());
	Select bank=new Select(d.findElement(By.id("selBank")));
	bank.selectByIndex(2);
	Select state=new Select(d.findElement(By.id("selState")));
	state.selectByVisibleText("Andhra Pradesh");
	Select city=new Select(d.findElement(By.id("selCity")));
	city.deselectByVisibleText("Hyderabad");
	Select branch=new Select(d.findElement(By.id("selBranch")));
	branch.selectByVisibleText("Achanta");
	return "Pass";
    }
catch(Exception e)
	{
	DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	Date dt=new Date();
	File scrFile=((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File("G:\\Quality Thought\\Result1\\"+dateFormat.format(dt)+".png"));
	return "Fail";
	}
	}
@BeforeMethod()
public void setUp()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterMethod()
public void down()
{
	d.close();
}
}
