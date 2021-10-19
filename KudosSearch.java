package Academy.Assignment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.ActivityPage;
import PageObjects.KudosSearchpage;
import PageObjects.Loginpage;
import Resources.base;

public class KudosSearch extends base {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	@Test
	public void sendKudos(){
		
		driver.get(prop.getProperty("url"));
		Loginpage lp = new Loginpage(driver);
		lp.getUsername().sendKeys("ashwini.koppad@qualitestgroup.com");
		lp.getPassword().sendKeys("P@ssw0rd");
		lp.clickLogin().click();
		
		ActivityPage aP = new ActivityPage(driver);
		aP.clickKudosSearch().click();
		
		KudosSearchpage ksp = new KudosSearchpage(driver);
		ksp.getEmail().sendKeys("anupam k");
		driver.findElement(By.xpath("//input[@id='s_e_add']")).sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
		driver.findElement(By.xpath("//input[@id='s_e_add']")).sendKeys(Keys.ENTER,Keys.RETURN);
		
		ksp.ClickSearch().click();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}

}
