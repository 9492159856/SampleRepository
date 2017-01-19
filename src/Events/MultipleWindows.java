package Events;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindows {
WebDriver d;
@Test()
public void test() throws Exception
{
	d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	Assert.assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
	d.findElement(By.xpath("//*[@id='demon_content']/div[2]/input")).click();
	d.findElement(By.xpath("//div[@id='bluemenu']/ul/li[3]/a")).click();
	Set<String>ff=d.getWindowHandles();
	System.out.print(ff.size());
	String handles[]=new String[ff.size()];
	int i=0;
	for(String rr:ff){
		System.out.println(rr);
		handles[i]=rr;
		i++;
	}
	d.switchTo().window(handles[0]);
	//Assert.assertTrue((d.findElement(By.xpath("//input[@id='usernameId']"))).isDisplayed());
	WebElement ff1=d.findElement(By.xpath("//input[@id='usernameId']"));
	System.out.println(ff1.isDisplayed());
	d.switchTo().window(handles[1]);
	Assert.assertTrue((d.findElement(By.xpath("//div[@id='conciergeCont']/table/tbody/tr[3]/td/table/tbody/tr/td[2]/input[1]"))).isDisplayed());
	
}
@BeforeMethod
public void setUp()
{
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterMethod
public void tearDown()
{
	d.close();
}
}