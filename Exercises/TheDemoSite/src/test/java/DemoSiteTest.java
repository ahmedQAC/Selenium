import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class DemoSiteTest {
	
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
	public void createUser() throws InterruptedException{
		DemoSiteLandingPage user = PageFactory.initElements(driver, DemoSiteLandingPage.class);
		user.createUser("Test", "password");
		
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.login("Test", "password");
		assertEquals("Login failed", "**Successful Login**", login.loginStatus());
		Thread.sleep(5000);
	}
}
