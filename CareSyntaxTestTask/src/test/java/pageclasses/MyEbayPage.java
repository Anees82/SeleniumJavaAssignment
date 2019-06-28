package pageclasses;

import org.openqa.selenium.WebDriver;

public class MyEbayPage extends BasePage {

	public MyEbayPage(WebDriver driver) {
		super(driver);
	}

	// LOCATORS

	private String userIdCss = "div.topTitle a:first-child";

	// METHODS

	public String getUserId() {
		return getElement(userIdCss).getText();
	}

}
