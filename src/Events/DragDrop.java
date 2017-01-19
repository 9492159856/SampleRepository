package Events;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragDrop {
		WebDriver d;
		@Test
		public void testDragNDrop() throws Exception
		{
			//Load web page
			d.get("http://jqueryui.com/droppable/");
			assertEquals("Droppable | jQuery UI",d.getTitle());
			//Switch driver focus to frame
			d.switchTo().frame(0);
			Actions a=new Actions(d);
			a.dragAndDrop(d.findElement(By.id("draggable")), d.findElement(By.id("droppable"))).perform();
			Thread.sleep(4000);
		}
		private void assertEquals(String string, String title) {
			// TODO Auto-generated method stub
			
		}
		@BeforeMethod
		public void setUp()
		{
			//Launch browser
			d=new FirefoxDriver();
			//Maximize
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		@AfterMethod
		public void tearDown()
		{
			//Close browser
			d.quit();
	
	}


}
