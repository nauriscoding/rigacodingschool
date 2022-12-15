import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
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
import org.openqa.selenium.chrome.ChromeDriver;
import TestData.LoginTestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.homePage;
import pages.loginPages;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Login {

	@BeforeAll
	public static void beforeAll() throws IOException, AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();	
		TestData.driver = new ChromeDriver();
		TestData.screenRecorder = new MyScreenRecorder("Login Test Scenarios", new File("./recordings/"));
		TestData.screenRecorder.start();
		TestData.driver.get("http://demo.guru99.com/v4");
		TestData.driver.manage().window().maximize();
		Thread.sleep(2000);		
		TestData.driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		Thread.sleep(2000);
	}
	@BeforeEach
	public void beforeEach() throws InterruptedException {
		TestData.driver.get("http://demo.guru99.com/v4");
	}
	
	@AfterAll
	public static void afterAll() throws IOException {
		TestData.screenRecorder.stop();
		TestData.driver.quit();
		
	}
	
	@Test
	@Order(1)
	@DisplayName("TC-L-1 - User enters valid Login information")
	public void tcl1() throws InterruptedException, IOException {

		TestData.driver.findElement(loginPages.usernameID).sendKeys(LoginTestData.userID);
		TestData.driver.findElement(loginPages.password).sendKeys(LoginTestData.password);
		TestData.driver.findElement(loginPages.loginButton).click();
		
		//Check the expected results
		String expectedResults = LoginTestData.welcome;
		String actualResults = TestData.driver.findElement(homePage.welcomeMessage).getText();
		if (actualResults.equals(expectedResults)) {
			System.out.println("TC-L-1 Test Passed!");
		} else {
			System.out.println("TC-L-1 Test Failed!"); 
		}
		
		assertEquals(expectedResults,actualResults);
		File shot = ((TakesScreenshot)TestData.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shot, new File("/Users/Nauris/screenshot/TC-L-1.jpg"));
		
		
		
	}
	
	@Test
	@Order(2)
	@DisplayName("TC-L-2 - User enters invalid Login information")
	public void tcl2() throws InterruptedException, IOException {
		
		
		TestData.driver.findElement(loginPages.usernameID).sendKeys(LoginTestData.invaliduserID);
		TestData.driver.findElement(loginPages.password).sendKeys(LoginTestData.invalidpassword);
		TestData.driver.findElement(loginPages.loginButton).click();
		
		//Check the expected results
	
		String actualText = TestData.driver.switchTo().alert().getText();
		String expectedText = LoginTestData.alertText;
		
		if (actualText.equals(expectedText)) {
			System.out.println("TC-L-2 Test Passed!");
		} else {
			System.out.println("TC-L-2 Test Failed!"); 
		}
		
		assertEquals(expectedText, actualText);
		

		TestData.driver.switchTo().alert().accept();
		File shot = ((TakesScreenshot)TestData.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shot, new File("/Users/Nauris/screenshot/TC-L-2.jpg"));
		
	}
	
	@Test
	@Order(3)
	@DisplayName("TC-L-3 User enters valid login and invalid password")
	public void tcl3() throws IOException {
		
		TestData.driver.findElement(loginPages.usernameID).sendKeys(LoginTestData.invaliduserID);
		TestData.driver.findElement(loginPages.password).sendKeys(LoginTestData.password);
		TestData.driver.findElement(loginPages.loginButton).click();
		
		//Check the expected results
	
		String actualText = TestData.driver.switchTo().alert().getText();
		String expectedText = LoginTestData.alertText;
		
		if (actualText.equals(expectedText)) {
			System.out.println("TC-L-3 Test Passed!");
		} else {
			System.out.println("TC-L-3 Test Failed!"); 
		}
		
		assertEquals(expectedText, actualText);
		

		TestData.driver.switchTo().alert().accept();
		File shot = ((TakesScreenshot)TestData.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shot, new File("/Users/Nauris/screenshot/TC-L-3.jpg"));
		
	}
	@Test
	@Order(4)
	@DisplayName("TC-L-5 User leaves blank login information fields, and check if the right message next to text box appears ")
	public void tcl5() throws IOException, InterruptedException {
		
		//Typing UserID

		TestData.driver.findElement(loginPages.usernameID).click();
		Thread.sleep(1000);
		TestData.driver.findElement(loginPages.password).click();
		Thread.sleep(1000);
		TestData.driver.findElement(loginPages.usernameID).click();
		Thread.sleep(1000);
		
		//check if the text next to user is correct
		String actualblankuserid = TestData.driver.findElement(By.id("message23")).getText();
		String expectedblankuserid = LoginTestData.userblank;
		assertEquals(actualblankuserid, expectedblankuserid);
		
		
		//check if the text next to password is correct
		String actualblankpassword = TestData.driver.findElement(By.id("message18")).getText();
		String expectedblankpassword = LoginTestData.passwordblank;
		assertEquals(actualblankpassword, expectedblankpassword);
	
		//Click on the button LOGIN
		TestData.driver.findElement(loginPages.loginButton).click();
		
		//Check the expected results
	
		String actualText = TestData.driver.switchTo().alert().getText();
		String expectedText = LoginTestData.alertText;
		
		if (actualText.equals(expectedText)) {
			System.out.println("TC-L-5 Test Passed!");
		} else {
			System.out.println("TC-L-5 Test Failed!"); 
		}
		
		assertEquals(expectedText, actualText);
		

		TestData.driver.switchTo().alert().accept();
		File shot = ((TakesScreenshot)TestData.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shot, new File("/Users/Nauris/screenshot/TC-L-5.jpg"));
		
	}
}
