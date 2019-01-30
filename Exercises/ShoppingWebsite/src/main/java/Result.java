import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Result {
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1/span[2]")
	private WebElement number;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1/span")
	private WebElement zeroResults;
	
	public String numberOfResults() {
		if (zeroResults!=null) {
			return "false";
		}
		else {
			String resultMessage = number.getText();
			char[] newResultMessage = resultMessage.toCharArray();
			int numberOfResults = (int)newResultMessage[0];
			if (numberOfResults > 0) {
				return "true";
			}
		}
		return "false";
	}
	
}
