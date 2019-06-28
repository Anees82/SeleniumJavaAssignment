package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.cssSelector(locator));
	}

	public List<WebElement> getElementList(String locator) {
		return driver.findElements(By.cssSelector(locator));
	}

	public Select getDropdown(String locator) {
		Select dropdown = new Select(driver.findElement(By.cssSelector(locator)));
		return dropdown;
	}

	public WebElement waitToBeClickable(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
		return element;
	}

	public void waitForAjax() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return typeof(jQuery)!='undefined' && jQuery.active==0");
	}

}
