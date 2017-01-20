package seenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MultiWindow {
WebDriver d;
@BeforeSuite
public void suite()
{
	d=new FirefoxDriver();
}
@Test
public void test()
{
	d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
	d.findElement(By.xpath("//*[@id='bluemenu']/ul/li[1]/a/span[2]/font")).click();
}
private void assertEquals(String string, String title) {
	// TODO Auto-generated method stub
	
}
	

}
