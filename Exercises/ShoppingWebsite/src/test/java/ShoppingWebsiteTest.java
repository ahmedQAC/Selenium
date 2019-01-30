import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingWebsiteTest {
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Constant constant = new Constant();
		driver.get(constant.URL);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void itemSearch() {
		SearchingItem search = PageFactory.initElements(driver, SearchingItem.class);
		search.searchItem("xbox");
		
		Result result = PageFactory.initElements(driver, Result.class);
		assertEquals("no results were found with that search", "true", result.numberOfResults());
	}
}
