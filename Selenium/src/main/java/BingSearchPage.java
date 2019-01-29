import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingSearchPage {

	@FindBy(xpath = "//*[@id=\"b_context\"]/li[1]/div/div[1]/h2")
	private WebElement softwareTest;
	
	public String getSearch() {
		return softwareTest.getText();
	}
}
