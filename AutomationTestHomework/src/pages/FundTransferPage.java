package pages;

import org.openqa.selenium.By;

public class FundTransferPage {
	public static By PayersAccNo = By.name("payersaccount");
	public static By PayeesAccNo = By.name("payeeaccount");
	public static By Amount = By.name("ammount");
	public static By Desc = By.name("desc");
	public static By Submit = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input[1]");
	public static By Reset = By.name("res");
	public static By FundText = By.cssSelector("body > table > tbody > tr:nth-child(1) > td > p");
	
}
