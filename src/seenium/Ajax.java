package seenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Ajax {
WebDriver d;
@BeforeSuite
public void abc()
{
	d=new FirefoxDriver();
}
@Test
public void cde() throws InterruptedException
{
	d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
	WebElement check=d.findElement(By.xpath("//*[@id='frmPincode']/span[1]"));
	Select dd=new Select(d.findElement(By.xpath("//*[@id='selBank']")));
	dd.selectByIndex(2);
	WebElement check1=d.findElement(By.xpath("//*[@id='frmPincode']/span[2]"));
	Select d1=new Select(d.findElement(By.xpath("//*[@id='selState']")));
	d1.selectByVisibleText("Himachal Pradesh");
	WebElement check2=d.findElement(By.xpath("//*[@id='frmPincode']/span[3]"));
	Select d2=new Select(d.findElement(By.xpath("//*[@id='selCity']")));
	d2.selectByVisibleText("Dharamshala");
	WebElement check3=d.findElement(By.xpath("//*[@id='frmPincode']/span[4]"));
	Select d3=new Select(d.findElement(By.xpath("//*[@id='selBranch']")));
	d3.selectByVisibleText("Dharamsala");
	d.findElement(By.id("txtifsccode")).sendKeys("5658");
	d.findElement(By.linkText("submit")).click();
	Thread.sleep(4000);
	d.close();
}
}
