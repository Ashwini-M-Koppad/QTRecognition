package Academy.Assignment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.ActivityPage;
import PageObjects.Loginpage;
import PageObjects.Sendkudospage;
import Resources.base;

public class KudosRecent extends base {
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
		
		ActivityPage aP=new ActivityPage(driver);
		aP.clickRecentKudos().click();
		
		Sendkudospage skp = new Sendkudospage(driver);
		skp.getWriteAppreciationMsg().click();
		skp.getComment().sendKeys("Good Work");
		skp.getSendButton().click();
	}
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}

}
