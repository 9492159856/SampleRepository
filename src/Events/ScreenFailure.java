package Events;

import java.io.File;
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

public class ScreenFailure {
		WebDriver d;
		@Test
		public void testScreenshot() throws Exception
		{
			Assert.assertEquals("Pass",getScreenshot());
			Thread.sleep(4000);	
		}
		public String getScreenshot() throws Exception
		{
			try
			{
				//Load web page
				d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
				Assert.assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India",d.getTitle());
				//Select bank
				Select bank=new Select(d.findElement(By.id("selBank")));
				bank.selectByIndex(4);
				//Select state
				Select state=new Select(d.findElement(By.id("selState")));
				state.selectByVisibleText("Andhra Pradesh");
				//Select city
				Select city=new Select(d.findElement(By.id("selCity")));
				city.selectByVisibleText("Hyderabad");
				//Select branch
				Select branch=new Select(d.findElement(By.id("selBranch")));
				branch.selectByVisibleText("Sanjeeva Reddy Nagar123");
				return "Pass";
			}
			catch(Exception e)
			{
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
				Date dt = new Date();
				File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		        FileUtils.copyFile(scrFile, new File("E:\\Selenium_Scripts_Mar16\\Results\\"+dateFormat.format(dt)+".png"));
		        return "Fail";
			}
		}
		@BeforeMethod
		public void setUp()
		{

			//Launch browser
			d=new FirefoxDriver();
			System.setProperty("webdriver.chrome.driver", "E:\\DriverServer\\chromedriver.exe");
			//d=new ChromeDriver();
			System.setProperty("webdriver.ie.driver", "E:\\DriverServer\\IEDriverServer.exe");
			//d=new InternetExplorerDriver();
			d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}
		@AfterMethod
		public void tearDown()
		{
			//Close browser
			d.quit();
		}

	}
