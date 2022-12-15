import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.loginPages;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Scenario - Login Functionality")
public class LoginFunctonalityTest {

	
	
	@BeforeAll
	public static void beforeAll() throws IOException, AWTException {
		WebDriverManager.chromedriver().setup();	
		TestData.driver = new ChromeDriver();
		TestData.screenRecorder = new MyScreenRecorder("Login Test Scenarios", new File("./recordings/"));
		TestData.screenRecorder.start();
	}
	
	@AfterAll
	public static void afterAll() throws IOException {
		//driver.close();
		TestData.screenRecorder.stop();
		TestData.driver.quit();
		
	}
	
	@Test
	@Order(3)
	@DisplayName("Login Test - Happy Path")
	public void tc001() throws InterruptedException, IOException {
		
		//Start record the video
		
		
		//Open the URL of Guru99
		TestData.driver.get("http://demo.guru99.com/v4");
		TestData.driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Closing the Iframe with GDPR Consent
		//TestData.driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		//Thread.sleep(2000);
		
		//Typing UserID
		TestData.driver.findElement(loginPages.usernameID).sendKeys("mngr461160");
		
		//Type the Password
		TestData.driver.findElement(loginPages.password).sendKeys("pebEzAm");
		
		//Click on the button LOGIN
		TestData.driver.findElement(loginPages.loginButton).click();
		
		//Check the expected results
		String expectedResults = "Welcome To Manager's Page of Guru99 Bank";
		String actualResults = TestData.driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td > marquee")).getText();
		
		//assertTrue will return true or false
		//assertTrue(actualResults.equals(expectedResults));
		//assertFalse(     );
		
		//assertEquals will compare two variables
		assertEquals(expectedResults,actualResults);
		//File shot = ((TakesScreenshot)TestData.driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(shot, new File("D:\\DESKTOP\a.jpg"));
		
		//Stop Record the video
		
		
	}
	
	@Test
	@Order(1)
	@DisplayName("Check results on entering Invalid User ID & Password")
	public void tc002() throws InterruptedException, IOException {
		//Open the URL
		TestData.driver.get("http://demo.guru99.com/v4");
		TestData.driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Closing the Iframe with GDPR Consent
		TestData.driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		Thread.sleep(2000);
		
		//WebDriverWait wait = new WebDriverWait(null, null);
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("save")));
		//element.click();
		
		//Closing the Iframe with GDPR Consent
		//driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		//Thread.sleep(1000);
		
		//Typing UserID
		TestData.driver.findElement(loginPages.usernameID).sendKeys("guru99");
		
		//Type the Password
		TestData.driver.findElement(By.name("password")).sendKeys("glass99");
		
		//Click on the button LOGIN
		TestData.driver.findElement(By.name("btnLogin")).click();
		
		String actualText = TestData.driver.switchTo().alert().getText();
		String expectedText = "User or Password is not valid";
		
		assertEquals(expectedText, actualText);
		
		TestData.driver.switchTo().alert().accept();
		File shot = ((TakesScreenshot)TestData.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shot, new File("D:\\Games\\Spirited (2022) [1080p] [WEBRip] [5.1] [YTS.MX]\\shit.jpg"));
		
	}
	
	@Test
	@Order(2)
	@DisplayName("Check response when a User ID is Empty & Login Button is pressed, and many more")
	public void tc003() {
		
		
	}
	
}

