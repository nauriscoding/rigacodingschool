package pages;

import org.openqa.selenium.By;

public class loginPages {
		
	public static By usernameID = By.name("uid");
	public static By password = By.name("password");
	public static By loginButton = By.name("btnLogin");
	public static By resetButton = By.name("uid");
	public static By welcomeText = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td > marquee");
}
