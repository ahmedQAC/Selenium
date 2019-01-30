import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PHPTravelTest {
	
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
	public void bookingPeople() {
		
	}
}
