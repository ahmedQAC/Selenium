import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement loginTab;
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="FormsButton2")
	private WebElement submitButton;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement loginMessage;
	
	public void login(String usernameInput, String passwordInput) {
		loginTab.click();
		username.sendKeys(usernameInput);
		password.sendKeys(passwordInput);
		submitButton.click();
	}
	
	public String loginStatus() {
		return loginMessage.getText();
	}
}
