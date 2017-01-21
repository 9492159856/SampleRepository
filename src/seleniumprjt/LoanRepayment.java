package seleniumprjt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoanRepayment 
{
WebDriver d;
@BeforeSuite
public void suite()
{
	d=new FirefoxDriver();
}
@Test
public void test()
{
	d.get("http://183.82.118.175:8080/Cyclos/do/login");
	d.findElement(By.id("cyclosUsername")).sendKeys("94554");
	d.findElement(By.id("cyclosPassword")).sendKeys("anu12345");
	d.findElement(By.xpath("//*[@id='cyclosLogin']/table/tbody/tr[3]/td/input")).click();
	d.findElement(By.xpath("")).click();
	d.findElement(By.xpath("")).click();
	d.findElement(By.xpath("")).click();
	d.findElement(By.xpath("")).click();
	d.findElement(By.xpath("")).sendKeys("10000");
	d.findElement(By.xpath("")).click();
	d.findElement(By.xpath("")).click();
	//Class.forName("oracle.jdbc.driver.OracleDriver");
	//Connection con=DriverManager.getConnection("jdbc:oracle://localhost:3306/orcl1","system","admin");
	//Statement stmt=con.createStatement();
	//ResultSet rs=stmt.executeQuery("");
	//while(rs.next())
	{
		//System.out.println(rs.getString("loan amount"));
	}
	//con.close();
}
	
}



