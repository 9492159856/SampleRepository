package Events;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class link {
		WebDriver d;
		@Test
		public void testLinks() throws Exception
		{
			//Load web page
			d.get("http://docs.seleniumhq.org/");
			Assert.assertEquals("Selenium - Web Browser Automation",d.getTitle());
			List<WebElement> l=d.findElements(By.xpath("//li[starts-with(@id,'menu')]"));
			System.out.println("No of links:"+l.size());
			System.out.println("***** Links are ******");
			String links[]=new String[l.size()];
			int i=0;
			for(WebElement e:l)
			{
				System.out.println(e.getText());
				links[i]=e.getText();
				i++;
			}
			for(String t:links)
			{
				
				d.findElement(By.linkText(t)).click();
				if(d.getTitle().contains("404"))
				{
					System.out.println("Link:"+t+" is not woking ");
				}
				else
				{
					System.out.println("Link:"+t+" is woking fine ");
				}
			}
		}
	
		@BeforeMethod
		public void setUp() throws Exception
		{

			d=new FirefoxDriver();
			d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			d.manage().window().maximize();
		}
		@AfterMethod
		public void tearDown()
		{
			//Close browser
			d.quit();
		}

	}
