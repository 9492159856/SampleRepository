package seenium;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.*;
	import org.testng.annotations.*;
	public class FileDownloading {
		WebDriver d;
		@BeforeMethod
		public void init()
		{
			d = new FirefoxDriver();
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
		}
		@AfterMethod
		public void stop()
		{
			//d.quit();
		}
		@Test
		public void testDownload() throws InterruptedException, IOException
		{
			
			d.get("http://docs.seleniumhq.org/download/");
			d.findElement(By.linkText("3.0.1")).click();
			Thread.sleep(2000);
			new ProcessBuilder("F:\\AutoIt3\\DownloadingFile.exe").start(); 
			Thread.sleep(8000);

			//d.findElement(By.xpath("//a[@name='client-drivers']/table/tbody/tr[1]/td[4]/a")).click();
		}

	}

