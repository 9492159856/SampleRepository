package anusha;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableGetSingleRowValues {
WebDriver d;
@Test()
public void test() throws InterruptedException 
{
    d.get("http://jqueryui.com/datepicker//");
    d.switchTo().frame(0);
    d.findElement(By.xpath("//input[@id='datepicker']")).click();
    WebElement ff=d.findElement(By.id("ui-datepicker-div"));
    List<WebElement>trows=ff.findElements(By.tagName("tr"));
    System.out.println(trows.size());
    List<WebElement>tcolumns1=ff.findElements(By.tagName("td"));
    System.out.println(tcolumns1.size());
    for(WebElement tdcolum:tcolumns1)
    {
        System.out.println(tdcolum.getText());
        if( tdcolum.getText().equals("16"))
        {
            tdcolum.findElement(By.linkText("16")).click();
            Thread.sleep(3000);
        }
    }    
}   
@BeforeMethod()
public void setup()
{
    d=new FirefoxDriver();
    d.manage().window().maximize();
    d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);  
}
@AfterMethod()
public void clearup()
{
	d.close();
}
}