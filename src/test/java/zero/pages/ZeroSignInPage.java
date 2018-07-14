package zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZeroSignInPage {

		public ZeroSignInPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(id = "user_login")
		public WebElement userName;
		
		@FindBy(id = "user_password")
		public WebElement passWord;
		
		@FindBy(name = "submit")
		public WebElement submitButton;
		
		public void logIn(String username, String password) {
			userName.sendKeys(username);
			passWord.sendKeys(password);
			submitButton.click();
		}
}
