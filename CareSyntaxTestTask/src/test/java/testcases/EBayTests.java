package testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageclasses.CreateUserPage;
import pageclasses.HomePage;
import pageclasses.MyEbayPage;
import pageclasses.SearchResultsPage;
import pageclasses.UserHomePage;

public class EBayTests {

	WebDriver driver;
	HomePage hp;
	List<String> list = new ArrayList<String>();

	@Test
	public void createUserAndSearchProduct() {

		CreateUserPage cp = hp.goToRegistrationPage();
		cp.enterFirstName("John");
		cp.enterLastName("Doe");
		cp.enterEmail("anecha1@yahoo.co.uk");
		cp.enterPassword("loveyou3000");
		UserHomePage uh = cp.clickRegisterBtn();
		MyEbayPage me = uh.goToMyEbayLink();
		list.add(me.getUserId());
		uh.enterSearchData("Intel NUC");
		SearchResultsPage sr = uh.clickSearchButton();
		list.add(sr.getNumberOfSearchResults());
		sr.clickBuyItNowTab();
		sr.click8GbMemory();
		sr.clickNewCondition();
		sr.setSortMenu("Lowest price");
		list.add(sr.getLowestPrice());

	}

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		hp = new HomePage(driver);

		driver.get(hp.getURL());

	}

	@AfterClass
	public void afterClass() {

		System.out.println("End Result: \nTotal Number: " + list.get(1) + "\nLowest Price: " + list.get(2)
				+ "\nUser ID: " + list.get(0));
		driver.quit();

	}

}
