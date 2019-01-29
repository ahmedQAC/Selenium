import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IngredientSearch {
	
	@FindBy(name="button") // or could have used (xpath = "//*[@id=\"root\"]/div/div/div/div/div/div/form/label/button")
	private WebElement softwareTest;
	
	public void dispayIngredients() {
		softwareTest.click();
	}
}
