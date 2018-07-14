package zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZeroHomePage {
	
	public ZeroHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//title")
	public WebElement homePageTitle;
	
	@FindBy(xpath = "//button")
	public WebElement signInButton;
	

	public void signIn() {
		signInButton.click();
	}
	
}
