package pageclasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	// LOCATOR STRINGS

	private String buyItNowCss = ".asp.pnl.left [title=\"Buy it now\"]";
	private String memory8GbCss = "input[aria-label=\"8 GB\"]";
	private String newConditionCss = "input[aria-label=\"New\"]";
	private String sortMenuCss = ".sort-menu-container";
	private String sortOptions = "#SortMenu li a";
	private String lowestPriceCss = "#ListViewInner li:first-child .lvprice span";
	private String numSrchResCss = ".rcnt";

	// METHODS

	public String getNumberOfSearchResults() {
		return getElement(numSrchResCss).getText();
	}

	public void clickBuyItNowTab() {
		getElement(buyItNowCss).click();
	}

	public void click8GbMemory() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", getElement(memory8GbCss));
		getElement(memory8GbCss).click();
	}

	public void clickNewCondition() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", getElement(memory8GbCss));
		getElement(newConditionCss).click();
	}

	public void setSortMenu(String sortBy) {

		getElement(sortMenuCss).click();

		for (WebElement item : getElementList(sortOptions)) {
			if (item.getText().equals(sortBy)) {
				item.click();
				break;
			}
		}

	}

	public String getLowestPrice() {
		return getElement(lowestPriceCss).getText();
	}

}
