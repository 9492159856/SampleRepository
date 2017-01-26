package seleniumprjt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class grantLoan {
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
		d.findElement(By.className("menuText")).click();
		d.findElement(By.id("memberName")).sendKeys("anusha.b");
		Thread.sleep(4000);
		d.findElement(By.xpath("//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td/fieldset/table/tbody/tr[1]/td[4]/input")).click();
		d.findElement(By.id("amount")).sendKeys("20000");
		d.findElement(By.id("description")).sendKeys(" Loan Granted");
		d.findElement(By.xpath("//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[17]/td/input")).click();
		d.findElement(By.xpath("//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[7]/td/input")).click();
		Alert al=d.switchTo().alert();
		al.accept();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle://localhost:3306/orcl1","system","admin");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("");
		while(rs.next())
		{
			System.out.println(rs.getString("loan amount"));
		}
		con.close();
		
		
}
}