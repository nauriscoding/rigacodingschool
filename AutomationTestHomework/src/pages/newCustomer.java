package pages;

import org.openqa.selenium.By;

public class newCustomer {

		public static By customerName = By.name("name");
		public static By DateOfBirth = By.name("dob");
		public static By address = By.name("addr");
		public static By city = By.name("city");
		public static By state = By.name("state");
		public static By pin = By.name("pinno");
		public static By mobile = By.name("telephoneno");
		public static By email = By.name("emailid");
		public static By password = By.name("password");
		public static By SubmitButton = By.name("sub");
		public static By maleGender = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(1)");
		public static By femaleGender = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(2)");
		public static By ResetButton = By.name("res");
		
}
