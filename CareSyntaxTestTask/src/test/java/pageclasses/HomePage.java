package pageclasses;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	private String url = "https://www.ebay.co.uk";

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// LOCATORS

	private String regLinkCss = "[href=\"https://reg.ebay.co.uk/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.co.uk%2F\"]";

	// METHODS

	public CreateUserPage goToRegistrationPage() {

		getElement(regLinkCss).click();
		return new CreateUserPage(driver);

	}

	public String getURL() {
		return url;
	}

}
