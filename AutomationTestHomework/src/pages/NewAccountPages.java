package pages;

import org.openqa.selenium.By;

public class NewAccountPages { 
	public static By customerID = By.name("cusid");
	public static By deposit = By.name("inideposit");
	public static By submitButton = By.name("button2");
	public static By AccountSucessfully = By.cssSelector("#account > tbody > tr:nth-child(1) > td > p");
	

}
