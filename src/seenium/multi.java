package seenium;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.FirefoxDriverProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class multi {
	WebDriver d;
	@Before
	public void setup()
	{
		//Launch browser
		d= new FirefoxDriver();
		//System.setProperty("webDriver.chrome.driver");
		
		d.manage().window().maximize();
			
	}
	
}
