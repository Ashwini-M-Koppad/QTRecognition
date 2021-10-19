package Academy.Assignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.ActivityPage;
import PageObjects.Loginpage;
import PageObjects.Sendkudospage;
import Resources.base;

public class SendKudos extends base {
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
		aP.clickSendkudos().click();
		Sendkudospage kudos = new Sendkudospage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		kudos.getEmailInKudosSearch().sendKeys("harshini.iyli@qualitestgroup.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(Keys.ENTER,Keys.RETURN);
		
		kudos.getWriteAppreciationMsg().click();
		kudos.getComment().sendKeys("Goood work");;
		kudos.getSendButton().click();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}

}
