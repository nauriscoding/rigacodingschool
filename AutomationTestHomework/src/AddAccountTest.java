import static org.junit.Assert.assertEquals;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.NewAccountPages;
import pages.homePage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Scenario - Add Account")
public class AddAccountTest {

	
	@BeforeAll
	public static void beforeAll() throws InterruptedException {
		WebDriverManager.chromedriver().setup();	
		TestData.driver = new ChromeDriver();
	}
	@BeforeEach
	public void beforeEach() throws InterruptedException {
		TestData.preConditionLogin();
	}
	@AfterAll
	public static void afterAll() {
		//driver.close();
		TestData.driver.quit();
		
	}
	
	@Test
	@Order(1)
	@DisplayName("TC-NA-1 - Enter valid information in all fields, create saving account")
	public void tcna1() throws InterruptedException, IOException {
		
		
		TestData.driver.findElement(homePage.leftMenuNewAccount).click();
		Thread.sleep(1000);
		TestData.driver.findElement(NewAccountPages.customerID).sendKeys(TestData.customerID);
		WebElement mySelectedElement = TestData.driver.findElement(By.name("selaccount"));
		Select dropdown= new Select(mySelectedElement);
		dropdown.selectByVisibleText("Savings");
		TestData.driver.findElement(NewAccountPages.deposit).sendKeys(TestData.depositamount);
		TestData.driver.findElement(NewAccountPages.submitButton).click();
		
		//Check the expected Results
		String expectedResults = (TestData.Successfully);
		String actualResults = TestData.driver.findElement(NewAccountPages.AccountSucessfully).getText();
		
		if (actualResults.equals(expectedResults)) {
			System.out.println("TC-NA-1 Test Passed!");
		} else {
			System.out.println("TC-NA-1 Test Failed!"); 
		}
		
		assertEquals(expectedResults, actualResults);
		
		//Check CustomerID
		actualResults = TestData.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]")).getText();
		assertEquals(TestData.customerID, actualResults);
		
		//Check Customer Name
		actualResults = TestData.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]")).getText();
		assertEquals(TestData.customerName, actualResults);
		
		// Check all the information
		actualResults = TestData.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]")).getText();
		assertEquals(TestData.accountsavings, actualResults);

		File shot = ((TakesScreenshot)TestData.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shot, new File("/Users/Nauris/screenshot/addAccountTC0013.jpg"));

	}
	
	@Test
	@Order(2)
	@DisplayName("TC-NA-2 - Enter INVALID information in all fields, create saving account")
	public void tcna2() throws InterruptedException, IOException {
		
		//Click on the Link to add a new Account
		TestData.driver.findElement(homePage.leftMenuNewAccount).click();
		Thread.sleep(1000);
		TestData.driver.findElement(NewAccountPages.customerID).sendKeys(TestData.invalidCustomerID);
		
		//Change account type to Savings
		WebElement mySelectedElement = TestData.driver.findElement(By.name("selaccount"));
		Select dropdown= new Select(mySelectedElement);
		dropdown.selectByVisibleText("Savings");

		//Add an initial deposit
		TestData.driver.findElement(NewAccountPages.deposit).sendKeys(TestData.depositamount);
		
		//Click on submit
		TestData.driver.findElement(NewAccountPages.submitButton).click();
		
		String actualText = TestData.driver.switchTo().alert().getText();
		String expectedText = TestData.alertnewaccount;

		
		if (actualText.equals(expectedText)) {
			System.out.println("TC-NA-1 Test Passed!");
		} else {
			System.out.println("TC-NA-1 Test Failed!"); 
		}
		
		assertEquals(expectedText, actualText);
		
		
	}
	
	
}