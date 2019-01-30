import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchingItem {
	@FindBy(id="search_query_top")
	private WebElement itemToSearch;
	
	@FindBy(name="submit_search")
	private WebElement submitButton;
	
	public void searchItem(String item) {
		itemToSearch.sendKeys(item);
		submitButton.click();
	}
}
