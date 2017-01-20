package seenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UploadingFileInAutoIt {
WebDriver d;
@BeforeSuite()
public void abc()
{
	d=new FirefoxDriver();
}
@Test()
public void cde() throws Exception
{
	d.get("https://www.sendspace.com/");
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	d.findElement(By.id("upload_file")).click();
	Thread.sleep(2000);
	new ProcessBuilder("F:\\AutoIt3\\Uploadfile.exe").start();
	Thread.sleep(4000);
	d.close();
}
}
