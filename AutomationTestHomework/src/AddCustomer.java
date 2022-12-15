import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.homePage;
import pages.newCustomer;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddCustomer {

	
	@BeforeAll
	public static void beforeAll() throws InterruptedException {
		WebDriverManager.chromedriver().setup();	
		TestData.driver = new ChromeDriver();
		TestData.preConditionLogin();
	}
	
	@AfterAll
	public static void afterAll() {
		//driver.close();
		TestData.driver.quit();
		
	}
	
	@Test
	@Order(1)
	@DisplayName("TC-NC-1 - Creating a new customer with valid data")
	public void tcnc1() throws InterruptedException {
		
		
		//click on New Customer
		TestData.driver.findElement(homePage.leftMenuNewCustomer).click();
		TestData.driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
		
		//Enter Customer Name
		TestData.driver.findElement(newCustomer.customerName).sendKeys(TestData.customerName);
		
		if(TestData.gender.equals("male")) {
			TestData.driver.findElement(newCustomer.maleGender).click();
			
		} else if(TestData.gender.equals("female")) {
			TestData.driver.findElement(newCustomer.femaleGender).click();
		}
		
	
		TestData.driver.findElement(newCustomer.DateOfBirth).sendKeys(TestData.dob);
		TestData.driver.findElement(newCustomer.address).sendKeys(TestData.address);
		TestData.driver.findElement(newCustomer.city).sendKeys(TestData.city);
		TestData.driver.findElement(newCustomer.state).sendKeys(TestData.state);
		TestData.driver.findElement(newCustomer.pin).sendKeys(TestData.pin);
		TestData.driver.findElement(newCustomer.mobile).sendKeys(TestData.mobilenumber);
		TestData.driver.findElement(newCustomer.email).sendKeys(TestData.email);
		TestData.driver.findElement(newCustomer.password).sendKeys(TestData.customerPassword);
		TestData.driver.findElement(newCustomer.SubmitButton).click();
		
		//Check the message: Customer created successfully 
		String actualResults = TestData.driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(1) > td > p")).getText();
		String expectedResults = "Customer Registered Successfully!!!";
		
		assertEquals(expectedResults,actualResults);
		
		//Check Customer Name
		actualResults = TestData.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]")).getText();
		assertEquals(TestData.customerName, actualResults);
		
		//Check Gender
		assertEquals(TestData.gender, TestData.driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(6) > td:nth-child(2)")).getText());
		
		//Check DOB
		assertEquals(TestData.expectedDOB, TestData.driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(7) > td:nth-child(2)")).getText());
		
		//CheckEmail
		assertEquals(TestData.email, TestData.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]")).getText());
		
		
		
	}
	
	@Test
	@Order(2)
	@DisplayName("TC-NC-2 - Creating a new customer with valid data pressing reset button")
	public void tcnc2() throws InterruptedException {

				TestData.driver.findElement(homePage.leftMenuNewCustomer).click();
				TestData.driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
				TestData.driver.findElement(newCustomer.customerName).sendKeys(TestData.customerName);
				
				if(TestData.gender.equals("male")) {
					TestData.driver.findElement(newCustomer.maleGender).click();
					
				} else if(TestData.gender.equals("female")) {
					TestData.driver.findElement(newCustomer.femaleGender).click();
				}
				
				TestData.driver.findElement(newCustomer.DateOfBirth).sendKeys(TestData.dob);

				TestData.driver.findElement(newCustomer.address).sendKeys(TestData.address);
				
				TestData.driver.findElement(newCustomer.city).sendKeys(TestData.city);
				
				TestData.driver.findElement(newCustomer.state).sendKeys(TestData.state);
				
				TestData.driver.findElement(newCustomer.pin).sendKeys(TestData.pin.toString());
				
				TestData.driver.findElement(newCustomer.mobile).sendKeys(TestData.mobilenumber);
				
				TestData.driver.findElement(newCustomer.email).sendKeys(TestData.email);
				
				TestData.driver.findElement(newCustomer.password).sendKeys(TestData.customerPassword);
				
				TestData.driver.findElement(newCustomer.ResetButton).click();
				
				assertEquals(TestData.empty, TestData.driver.findElement(newCustomer.customerName).getText());
				assertEquals(TestData.empty, TestData.driver.findElement(newCustomer.address).getText());
				assertEquals(TestData.empty, TestData.driver.findElement(newCustomer.city).getText());
				assertEquals(TestData.empty, TestData.driver.findElement(newCustomer.state).getText());
				assertEquals(TestData.empty, TestData.driver.findElement(newCustomer.pin).getText());
				assertEquals(TestData.empty, TestData.driver.findElement(newCustomer.mobile).getText());
				assertEquals(TestData.empty, TestData.driver.findElement(newCustomer.password).getText());
				
		
	}
	
	@Test 
	@Order(2)
	@DisplayName("TC-NC-5 - Entering special charaters in fields")
	public void tcnc5() throws InterruptedException {
		TestData.driver.findElement(homePage.leftMenuNewCustomer).click();
		TestData.driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
		TestData.driver.findElement(newCustomer.customerName).sendKeys(TestData.specialchar);

		TestData.driver.findElement(newCustomer.address).sendKeys(TestData.specialchar);
		
		TestData.driver.findElement(newCustomer.city).sendKeys(TestData.specialchar);
		
		TestData.driver.findElement(newCustomer.state).sendKeys(TestData.specialchar);
		
		TestData.driver.findElement(newCustomer.pin).sendKeys(TestData.specialchar);
		
		TestData.driver.findElement(newCustomer.mobile).sendKeys(TestData.specialchar);
		
		// Special characters are not allowed should show next to each text box
		String nexttoname = TestData.driver.findElement(By.id("message")).getText();
		String nexttoaddress = TestData.driver.findElement(By.id("message3")).getText();
		String nexttocity = TestData.driver.findElement(By.id("message4")).getText();
		String nexttostate = TestData.driver.findElement(By.id("message5")).getText();
		String nexttopin = TestData.driver.findElement(By.id("message6")).getText();
		String nexttomobile = TestData.driver.findElement(By.id("message7")).getText();

		assertEquals(TestData.specialCharNotAllowed, nexttoname);
		assertEquals(TestData.specialCharNotAllowed, nexttoaddress);
		assertEquals(TestData.specialCharNotAllowed, nexttocity);
		assertEquals(TestData.specialCharNotAllowed, nexttostate);
		assertEquals(TestData.specialCharNotAllowed, nexttopin);
		assertEquals(TestData.specialCharNotAllowed, nexttomobile);
	
		
	}
	
	
	
}

