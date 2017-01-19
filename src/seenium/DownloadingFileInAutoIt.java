package seenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DownloadingFileInAutoIt {
WebDriver d;
@BeforeSuite()
public void abc()
{
	d=new FirefoxDriver();
}
@Test()
public void cde() throws Exception
{
	d.get("http://www.seleniumhq.org/");
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	d.findElement(By.linkText("Download")).click();
	d.findElement(By.linkText("3.0.1")).click();

	new ProcessBuilder("F:\\AutoIt3\\DownloadingFile.exe").start();
	Thread.sleep(4000);
}
}
