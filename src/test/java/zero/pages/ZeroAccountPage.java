package zero.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZeroAccountPage {

	public ZeroAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class='nav nav-tabs']/li")
//	@FindBy(xpath = "//div[contains(@class, 'nav nav-tabs')]")
	public List<WebElement> navTabs;
	
	@FindBy(xpath = "(//table)[1]//tr//td[1]")
	public List<WebElement> cashAccount;
	
	@FindBy(xpath = "(//table)[2]//tr//td[1]")
	public List<WebElement> investmentAccount;
	
	@FindBy(xpath = "(//table)[3]//tr//td[1]")
	public List<WebElement> creditAccount;
	
	@FindBy(xpath = "(//table)[4]//tr//td[1]")
	public List<WebElement> loanAccount;
	
	
}
