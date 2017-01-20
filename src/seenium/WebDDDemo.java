package seenium;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDDDemo {
	WebDriver d;
	@Before
	public void abc()
	{
		d=new FirefoxDriver();
	}
	@Test
	public void xyz() throws InterruptedException
	{
		d.get("http://book.theautomatedtester.co.uk/");
		d.manage().window().maximize();
		d.findElement(By.linkText("Chapter1")).click();
		WebElement radio=d.findElement(By.id("radiobutton"));
		if(radio.isSelected())
		{
			System.out.println("Radio button already selected");
		}
		else
		{
		radio.click();
		}
	Select dd=new Select(d.findElement(By.id("selecttype")));
	dd.selectByIndex(1);
	Thread.sleep(4000);
	d.close();
	}		
}
