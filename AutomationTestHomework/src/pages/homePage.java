package pages;

import org.openqa.selenium.By;

public class homePage {

	public static By welcomeMessage = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td > marquee");
	public static By leftMenuNewCustomer = By.linkText("New Customer");
	public static By leftMenuEditCustomer = By.linkText("Edit Customer");
	public static By leftMenuNewAccount= By.linkText("New Account");
	public static By LeftMenuFundTransfer = By.xpath("/html/body/div[3]/div/ul/li[10]/a");
}
