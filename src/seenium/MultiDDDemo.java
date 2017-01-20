package seenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MultiDDDemo {
WebDriver d;
@BeforeMethod
public void abc()
{
d=new FirefoxDriver();
}
@Test
public void abc1() throws InterruptedException
{
	d.get("https://eenadupellipandiri.net/register");
	d.findElement(By.id("name")).sendKeys("Anusha");
	//WebElement check=d.findElement(By.id("registered"));
	Select dd=new Select(d.findElement(By.id("registered_by")));
	dd.selectByIndex(2);
	d.findElement(By.xpath("//*[@id='innregister']/form/div[1]/div[3]/span[1]/input")).sendKeys("selenium@gmail.com");
	//d.findElement(By.id("email_status")).clear();
	//d.findElement(By.id("email_status")).click();
	d.findElement(By.xpath("//input[@value='F']")).click();;
	WebElement check=d.findElement(By.xpath("//*[@id='innregister']/form/div[1]/div[5]/label"));
	Select d1=new Select(d.findElement(By.xpath("//*[@id='dob_day']")));
	d1.selectByIndex(5);
	Select d2=new Select(d.findElement(By.xpath("//*[@id='dob_month']")));
	d2.selectByIndex(4);
	Select d3=new Select(d.findElement(By.xpath("//*[@id='dob_year']")));
	d3.selectByIndex(4);
	d.findElement(By.xpath("//*[@id='innregister']/form/div[1]/div[6]/input")).sendKeys("Hyd");
	WebElement check1=d.findElement(By.xpath("//*[@id='innregister']/form/div[1]/div[7]/label"));
	Select d4=new Select(d.findElement(By.xpath("//*[@id='top_hour']")));
	d4.selectByIndex(4);
	Select d5=new Select(d.findElement(By.xpath("//*[@id='tob_minute']")));
	d5.selectByIndex(4);
	Select d6=new Select(d.findElement(By.xpath("//*[@id='tob_moc']")));
	d6.selectByIndex(2);
	WebElement check2=d.findElement(By.xpath("//*[@id='innregister']/form/div[1]/div[8]/label"));
	Select d7=new Select(d.findElement(By.xpath("//*[@id='marital_status']")));
	d7.selectByIndex(0);
	d.findElement(By.xpath("//input[@value='N']"));
	WebElement check3=d.findElement(By.xpath("//*[@id='innregister']/form/div[1]/div[10]/label"));
	Select d8=new Select(d.findElement(By.xpath("//*[@id='height']")));
	d8.selectByIndex(6);
	d.findElement(By.xpath("//input[@name='weight']")).sendKeys("50");
	d.findElement(By.xpath("//input[@value='average']")).click();
	d.findElement(By.xpath("//input[@value='fair']")).click();
	WebElement check4=d.findElement(By.xpath("//*[@id='innregister']/form/div[1]/div[14]"));
	Select d9=new Select(d.findElement(By.xpath("//*[@id='bloodgroup']")));
	d9.selectByIndex(2);
	d.findElement(By.xpath("//*[@id='physical_status']")).click();
	WebElement check5=d.findElement(By.xpath("//*[@id='innregister']/form/div[1]/div[16]/label"));
	Select d10=new Select(d.findElement(By.xpath("//*[@id='mother_tongue']")));
	d10.selectByIndex(2);
	WebElement check6=d.findElement(By.xpath("//*[@id='innregister']/form/div[1]/div[17]/label"));
	Select d11=new Select(d.findElement(By.xpath("//*[@id='can_speak_lang']")));
	d11.selectByIndex(0);
	d.findElement(By.xpath("//*[@id='personalvalues']")).sendKeys("She is one the number in our fmly");
	WebElement check7=d.findElement(By.xpath("//*[@id='innregister']/form/div[3]/div[1]/label"));
	Select d12=new Select(d.findElement(By.xpath("//*[@id='religion']")));
	d12.selectByIndex(2);
	WebElement check8=d.findElement(By.xpath("//*[@id='innregister']/form/div[3]/div[2]/label"));
	Select d13=new Select(d.findElement(By.xpath("//*[@id='caste']")));
	d13.selectByIndex(1);
	d.findElement(By.xpath("//input[@name='sub_caste']")).sendKeys("Kamma");
	d.findElement(By.xpath("//*[@id='manglik']")).click();
	d.findElement(By.xpath("//input[@name='diet']")).click();
	d.findElement(By.xpath("//input[@name='smoke']")).click();
	d.findElement(By.xpath("//input[@name='drink']")).click();
	d.findElement(By.xpath("//*[@id='interest_hobbies']")).sendKeys("Listening music");
	d.findElement(By.xpath("//input[@name='Continue']")).click();
	Thread.sleep(4000);
	d.close();
}
}