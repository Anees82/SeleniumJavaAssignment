package pageclasses;

import org.openqa.selenium.WebDriver;

public class UserHomePage extends BasePage {

	public UserHomePage(WebDriver driver) {
		super(driver);
	}

	/* LOCATOR STRINGS */

	private String myEbayLinkCss = "[href=\"https://my.ebay.co.uk/ws/eBayISAPI.dll?MyEbay&gbh=1\"]";
	private String searchFieldCss = "#gh-ac";
	private String searchButtonCss = "[type=\"submit\"]";

	/* METHODS */

	public MyEbayPage goToMyEbayLink() {
		getElement(myEbayLinkCss).click();
		return new MyEbayPage(driver);
	}

	public void enterSearchData(String srchText) {
		getElement(searchFieldCss).sendKeys(srchText);
	}

	public SearchResultsPage clickSearchButton() {
		getElement(searchButtonCss).click();
		return new SearchResultsPage(driver);
	}

}
