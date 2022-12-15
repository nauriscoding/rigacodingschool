
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestData {

	public static WebDriver driver = null;
	public static MyScreenRecorder screenRecorder;
	
	
	//precondition 
	public static void preConditionLogin() throws InterruptedException {
		
		//Open the URL
		driver.get("http://demo.guru99.com/v4");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		Thread.sleep(2000);
		
		//Enter the userID
		driver.findElement(By.name("uid")).sendKeys("mngr461160");
		
		//Enter the password
		driver.findElement(By.name("password")).sendKeys("123456a!");
		
		//Click on login
		driver.findElement(By.name("btnLogin")).click();
		
	}
	///
	
	
	//new customer test data
	public static String customerName = "Nauris";
	public static String gender = "male";
	public static String dob = "12/31/1989";
	public static String expectedDOB = "1989-12-31";
	public static String address = "100 Testing street";
	public static String city = "Liepaja";
	public static String state = "Latvia";
	public static String pin = "666777";
	public static String pins = "666777";
	public static String mobilenumber = "12345678";
	static Random random = new Random();
	public static int numberRandom = random.nextInt(100000);  
	public static String email = "nauris"+numberRandom+"@guru99.com"; 
	public static String customerPassword = "1234567";
	public static String empty ="";
	public static String specialchar ="/*&@#";
	public static String specialCharNotAllowed = "Special characters are not allowed";
	//
	
	//new account
	public static String customerID = "55181";
	public static String accountID = "115573";
	public static String depositamount = "10000";
	public static String Successfully = "Account Generated Successfully!!!";
	public static String IDemail = "nauristesting100@testing.co.uk";
	public static String accountsavings = "Savings";
	public static String invalidCustomerID = "01010";
	public static String alertnewaccount = "Customer does not exist!!";
	//
	
	//Fund transfer
	public static String Payersaccountno = "115622";
	public static String Payeesaccountno = "115623";
	public static String FundAmount = "62";
	public static String Description = "Milk!";
	public static String FundText = "Fund Transfer Details";
	//
		
	// import todays date
	
	public class CurrentDateTimeExample2 {
		public static void main(String[] args) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			System.out.println(formatter.format(date));
		}
		}
	
	
}
