import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FundTransferPage;
import pages.homePage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FundTransfer {

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
		
		TestData.driver.quit();
		
	}
	
	@Test
	@Order(1)
	@DisplayName("TC-FT-1 - Enter valid information in all deposit fields")
		public void tcft1() throws InterruptedException, IOException {
		//Click on the Link to add a new Account
		TestData.driver.findElement(homePage.LeftMenuFundTransfer).click();

		Thread.sleep(1000);
		
		TestData.driver.findElement(FundTransferPage.PayersAccNo).sendKeys(TestData.Payersaccountno);
		TestData.driver.findElement(FundTransferPage.PayeesAccNo).sendKeys(TestData.Payeesaccountno);
		TestData.driver.findElement(FundTransferPage.Amount).sendKeys(TestData.FundAmount);
		TestData.driver.findElement(FundTransferPage.Desc).sendKeys(TestData.Description);
		
		TestData.driver.findElement(FundTransferPage.Submit).click();
		
		//testing if receiving valid information
		String expectedResults = (TestData.FundText);
		String actualResults = TestData.driver.findElement(FundTransferPage.FundText).getText();
		assertEquals(expectedResults, actualResults);
		// Check From Account Number
		actualResults = TestData.driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]")).getText();
		assertEquals(TestData.Payersaccountno, actualResults);
		// Check To Account Number
		actualResults = TestData.driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")).getText();
		assertEquals(TestData.Payeesaccountno, actualResults);
		// Check Amount
		actualResults = TestData.driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]")).getText();
		assertEquals(TestData.FundAmount, actualResults);
		// Check Description
		actualResults = TestData.driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]")).getText();
		assertEquals(TestData.Description, actualResults);
	}
	}