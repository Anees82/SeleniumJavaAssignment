package pageclasses;

import org.openqa.selenium.WebDriver;

public class CreateUserPage extends BasePage {

	public CreateUserPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * LOCATORS
	 */
	private String fNameCss = "#firstname";
	private String lNameCss = "#lastname";
	private String emailCss = "#email";
	private String passwordCss = "#PASSWORD";
	private String regButtonCss = "#ppaFormSbtBtn";

	public void enterFirstName(String fName) {
		getElement(fNameCss).sendKeys(fName);
	}

	public void enterLastName(String lName) {
		getElement(lNameCss).sendKeys(lName);
	}

	public void enterEmail(String email) {
		getElement(emailCss).sendKeys(email);
	}

	public void enterPassword(String password) {
		getElement(passwordCss).sendKeys(password);
	}

	public UserHomePage clickRegisterBtn() {
		waitToBeClickable(regButtonCss).click();
		return new UserHomePage(driver);
	}

}
