package seenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElementsDemo {
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
	//Type text
	d.findElement(By.id("q")).sendKeys("Selenium");
	//Click on chapter1 link
	d.findElement(By.linkText("Chapter1")).click();
	//Radio button
	WebElement radio = d.findElement(By.id("radiobutton"));
	if(radio.isSelected())
	{
		System.out.println("Radio button is already selected");
	}
	else
	{
		radio.click();
	}
	//Check box
	WebElement checkbox = d.findElement(By.name("selected(1234)"));
	if(checkbox.isSelected())
	{
		System.out.println("Check box is already selected");
	}
	else
	{
		checkbox.click();
	}
	//Drop Down
	Select dd=new Select(d.findElement(By.id("selecttype")));
	dd.selectByIndex(2);
	//Text Area
	d.findElement(By.id("html5div")).clear();
	d.findElement(By.id("html5div")).sendKeys("Automation");
	//pause 4sec
	Thread.sleep(4000);
	//Close browser
	d.close();

}

}
