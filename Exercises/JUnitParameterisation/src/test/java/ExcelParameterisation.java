import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

@RunWith(Parameterized.class)
public class ExcelParameterisation {
	
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
	
	@Parameters
	public static List<Object[]> data() throws IOException{
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Documents\\Selenium\\Data driven testing\\DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Object[][] ob = new Object[sheet.getPhysicalNumberOfRows()-1][4];
		
//		Reading
		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
				ob[rowNum][0] = sheet.getRow(rowNum).getCell(0).getStringCellValue();
				ob[rowNum][1] = sheet.getRow(rowNum).getCell(1).getStringCellValue();
				ob[rowNum][2] = sheet.getRow(rowNum).getCell(2).getStringCellValue();
				ob[rowNum][3] = rowNum;
			}
		return Arrays.asList(ob);
		}
	
		private String username;
		private String password;
		private String expected;
		private int row;
		
		public ExcelParameterisation(String username, String password, String expected, int row) {
			this.username = username;
			this.password = password;
			this.expected = expected;
			this.row = row;
	}
		@Test
		public void login() {
			// testing logic
			DemoSiteLandingPage user = PageFactory.initElements(driver, DemoSiteLandingPage.class);
			Login login = PageFactory.initElements(driver, Login.class);
			user.createUser(username, password);
			login.login(username, password);
			String actualValue = login.loginStatus();
			
			System.out.println(username + " " + password + " " + expected);
			// grab actual result and insert it into spreadsheet
			System.out.println("actual result needs to be printed in row:" + row);
			
			try {
				assertEquals("Expected and actual values are not equal", expected, actualValue); //assertEquals("error message", expected value, actual value);
				// write pass to excel sheet
			}
			catch (AssertionError e) {
				// write fail to excel sheet
				Assert.fail(); // Because AssertionError was caught, test no longer fails,
								// therefore we force it to fail after we have written it to excel sheet
			}
		}
}
	
