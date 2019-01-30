import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDemonstration {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void esty() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://wwww.bing.com");
		WebElement textbox = driver.findElement(By.name("q"));
		textbox.sendKeys("Selenium");
		textbox.submit();
		WebElement sele = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
		Thread.sleep(3000);
		assertEquals("Selenium Text not found", "Selenium", sele.getText());
		
		driver.get("http://localhost:3000/YourIngredientsPage");
		WebElement button = driver.findElement(By.name("button"));
		button.submit();
		Thread.sleep(5000);
		
	}
	
	@Test
	@Ignore
	public void bingSearch() throws InterruptedException{
		driver.get("https://www.bing.com/");
		BingLandingPage bingLandingPage = PageFactory.initElements(driver, BingLandingPage.class);
		bingLandingPage.searchBing("Selenium");
		
		BingSearchPage bingSearchPage = PageFactory.initElements(driver, BingSearchPage.class);
		assertEquals("Selenium not found", "Selenium", bingSearchPage.getSearch());
		Thread.sleep(2000);
	}
	
	@Test
	@Ignore
	public void getAllIngredients() throws InterruptedException {
		Constant constant = new Constant();
		driver.get(constant.URL);
		IngredientSearch ingredientSearch = PageFactory.initElements(driver, IngredientSearch.class);
		ingredientSearch.dispayIngredients();
		Thread.sleep(5000);
	}
	
	@Test
	@Ignore
	public void implicitWait() throws InterruptedException {
		driver.get("https://christophperrins.github.io/TestingSite/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement myDynamicElement = driver.findElement(By.xpath("//*[@id=\"quote\"]/h2"));
		assertEquals("-The Shafeeq not found", "-The Shafeeq", myDynamicElement.getText());
	}
	
//	@Test
//	
//	public void explicitWait() throws InterruptedException {
//		driver.get("https://christophperrins.github.io/TestingSite/"); 
//		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.textToBePresentInElement(element, )(By.xpath("//*[@id=\"quote\"]/h2"))); 
//		assertEquals("-The Shafeeq not found", "-The Shafeeq", myDynamicElement.getText());
//	}
//	
//	@Test
//	public void fluentWait() {
//		
//	}
}
