package Events;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;


public class ScreenShotDemo1 {
WebDriver d;
@BeforeMethod()
public void setUp()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@Test()
public void test() throws IOException
{
	d.get("https://www.google.co.in/");
	Assert.assertEquals("Google",d.getTitle());
	d.findElement(By.linkText("Gmail")).click();
	//Current Date and Time
	DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	Date dt=new Date();
	//System.out.println(dateFormat.format(dt));

    // then Augmenter will add the TakesScreenshot methods to the instance
	File srcFile=((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File("G:\\Quality Thought\\Result" +dateFormat.format(dt)+".png"));
}

@AfterMethod()
public void tearDown()
{
	d.close();
}
}
