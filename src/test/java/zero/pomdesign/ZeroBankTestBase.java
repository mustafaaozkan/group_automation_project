package zero.pomdesign;

import static zero.pomdesign.ZeroBankUtilities.getMyValue;

import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import zero.pages.ZeroAccountPage;
import zero.pages.ZeroHomePage;
import zero.pages.ZeroSignInPage;

public class ZeroBankTestBase {
	WebDriver driver;
	ZeroHomePage homePage;
	ZeroSignInPage signInPage;
	ZeroAccountPage accountPage;
	ZeroBankUtilities utilClass;
	
	String expected;
	String actual;
	
	List<String> expectedL;
	List<String> actualL;
	
	SortedSet<String> expectedS;
	SortedSet<String> actualS;
	
	SoftAssert sass;

	@BeforeClass
	public void setUpClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeMethod
	public void setUpTest() {
		driver = new ChromeDriver();
		driver.get(getMyValue("zeroBank.url"));
		
		homePage = new ZeroHomePage(driver);
		signInPage = new ZeroSignInPage(driver);
		accountPage = new ZeroAccountPage(driver);
		
		
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void tearDownTest() {
		driver.close();
	}

	@AfterClass
	public void tearDownClass() {
	}

}
