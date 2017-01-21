package seleniumprjt;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.seleniumhq.jetty9.io.Connection;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class MemberCreation {
WebDriver d;
@BeforeSuite
public void suite()
{
	d=new FirefoxDriver();
}
@Test
public void test1() throws Exception
{
	d.get("http://183.82.118.175:8080/Cyclos/do/login");
	d.findElement(By.id("cyclosUsername")).sendKeys("admin");
	d.findElement(By.id("cyclosPassword")).sendKeys("admin");
	d.findElement(By.xpath("//*[@id='cyclosLogin']/table/tbody/tr[3]/td/input")).click();
	d.findElement(By.xpath("//*[@id='menu5']/span[2]")).click();
	d.findElement(By.xpath("//*[@id='submenu5.0']/span[2]")).click();
	WebElement check=d.findElement(By.xpath("//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[1]"));
	Select dd=new Select(d.findElement(By.xpath("//*[@id='newMemberGroup']")));
	dd.selectByIndex(12);
	d.findElement(By.xpath("//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("anusha.b ");
	d.findElement(By.xpath("//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).sendKeys("abc123@gmail.com");
	d.findElement(By.id("assignPasswordCheck")).click();
	d.findElement(By.xpath("//input[@type='password']")).sendKeys("anu12345");
	d.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("anu12345");
	//d.findElement(By.id("saveAndNewButton")).click();
	d.findElement(By.id("saveAndOpenProfileButton")).click();
	Alert al=d.switchTo().alert();
	al.accept();
	d.findElement(By.className("menuText")).click();
	d.findElement(By.id("memberName")).sendKeys("anusha.b");
	String s=d.findElement(By.xpath("//tr[5]/td[2]/input")).getAttribute("value");
	String s1=d.findElement(By.xpath("//tr[6]/td[2]/input")).getAttribute("value");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	java.sql.Connection con=DriverManager.getConnection("jdbc:oracle://localhost:3306/orcl1","system","admin");
	Statement stmt=((java.sql.Connection) con).createStatement();
	ResultSet rs=stmt.executeQuery("");
	while(rs.next())
	{
		System.out.println(rs.getString("name")+rs.getString("email"));
	}
	con.close();
	
	
}
}
