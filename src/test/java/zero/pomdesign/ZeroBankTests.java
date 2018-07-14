package zero.pomdesign;

import static org.testng.Assert.assertEquals;
import static zero.pomdesign.ZeroBankUtilities.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import zero.pages.ZeroAccountPage;
import zero.pages.ZeroHomePage;
import zero.pages.ZeroSignInPage;

public class ZeroBankTests extends ZeroBankTestBase {

	@Test(priority = 1, description = "verifying signin functionality")
	public void signInTest() {
		expected = "Zero - Personal Banking - Loans - Credit Cards";
		actual = driver.getTitle();
		assertEquals(actual, expected, "You are not at the right website!!");
		homePage.signIn();
		expected = "Zero - Log in";
		actual = driver.getTitle();

		assertEquals(actual, expected, "You are not at the right webPage!!");

		signInPage.logIn(getMyValue("zeroBank.username"), getMyValue("zeroBank.password"));
		expected = "Zero - Account Summary";
		actual = driver.getTitle();

		assertEquals(actual, expected, "You are not Logged in!!");

	}

	@Test(priority = 2, description = "verifying account page")
	public void accountTest() {
		homePage.signIn();

		signInPage.logIn(getMyValue("zeroBank.username"), getMyValue("zeroBank.password"));

		expectedL = new ArrayList<>();

		expectedL.add("Zero - Account Summary");
		expectedL.add("Zero - Account Activity");
		expectedL.add("Zero - Transfer Funds");
		expectedL.add("Zero - Pay Bills");
		expectedL.add("Zero - My Money Map");
		expectedL.add("Zero - Online Statements");

		actualL = new ArrayList<>();
		// accountPage.navTabs.forEach( elem->
		// {elem.click();actual.add(driver.getTitle());});
		// System.out.println(actual);
		for (WebElement elem : accountPage.navTabs) {
			elem.click();
			actualL.add(driver.getTitle());
		}
		System.out.println(actualL);
		assertEquals(actualL, expectedL, "You are not in the right account page");
	}

	@Test(priority = 3, description = "testing cash accounts")
	public void cashAccountTest() {
		homePage.signIn();
		signInPage.logIn(getMyValue("zeroBank.username"), getMyValue("zeroBank.password"));
		// Testing cash account
		expectedS = new TreeSet<>();
		expectedS.add("Checkings");
		expectedS.add("Savings");
		actualL = new ArrayList<>();
		for (WebElement elem : accountPage.cashAccount) {
			actualL.add(elem.getText());
		}
		actualS = new TreeSet<>(actualL);
		assertEquals(actualS, expectedS, "Cash accounts must include: " + expectedS);
	}

	@Test(priority = 4, description = "testing investment accounts")
	public void investmentAccountTest() {
		homePage.signIn();
		signInPage.logIn(getMyValue("zeroBank.username"), getMyValue("zeroBank.password"));
		// Testing Investment account
		expectedS = new TreeSet<>();
		expectedS.add("Brokerage");

		actualL = new ArrayList<>();
		for (WebElement elem : accountPage.investmentAccount) {
			actualL.add(elem.getText());
		}
		actualS = new TreeSet<>(actualL);

		assertEquals(actualS, expectedS, "Investment accounts can only include: " + expectedS);
	}

	@Test(priority = 5, description = "testing credit accounts")
	public void creditAccountTest() {
		homePage.signIn();
		signInPage.logIn(getMyValue("zeroBank.username"), getMyValue("zeroBank.password"));
		// Testing Credit account
		expectedS = new TreeSet<>();
		expectedS.add("Credit Card");

		actualL = new ArrayList<>();
		for (WebElement elem : accountPage.creditAccount) {
			actualL.add(elem.getText());
		}
		actualS = new TreeSet<>(actualL);
		System.out.println(actualS);
		assertEquals(actualS, expectedS, "Credit accounts can only include: " + expectedS);
	}

	@Test(priority = 6, description = "testing loan accounts")
	public void loanAccountTest() {
		homePage.signIn();
		signInPage.logIn(getMyValue("zeroBank.username"), getMyValue("zeroBank.password"));
		// Testing Loan account
		expectedS = new TreeSet<>();
		expectedS.add("Loan");

		actualL = new ArrayList<>();
		for (WebElement elem : accountPage.loanAccount) {
			actualL.add(elem.getText());
		}
		actualS = new TreeSet<>(actualL);
		assertEquals(actualS, expectedS, "Loan accounts can only include: " + expectedS);
	}

}
