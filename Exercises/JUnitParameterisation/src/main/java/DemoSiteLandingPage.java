import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoSiteLandingPage {

	@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement addUserTab;
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="FormsButton2")
	private WebElement submitButton;
	
	public void createUser(String usernameInput, String passwordInput) {
		addUserTab.click();
		username.sendKeys(usernameInput);
		password.sendKeys(passwordInput);
		submitButton.click();
	}
	
}
