import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.PageFactory;

@RunWith(Parameterized.class)
public class ExcelParameterisationTest { //The class needs to be either start with Test, or end with Test for this to be considered as a test.
	

	
	@Before
	public void setup() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		//driver = new ChromeDriver();
		System.setProperty("phantomjs.binary.path", Constant.PHANTOMDRIVER); //this is how you would do it using phantom
		driver = new PhantomJSDriver();



	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Parameters
	public static Collection<Object[]> data() throws IOException{
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Documents\\Selenium\\Data driven testing\\DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Object[][] ob = new Object[sheet.getPhysicalNumberOfRows()-1][4];
		
//		Reading
		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
				ob[rowNum-1][0] = sheet.getRow(rowNum).getCell(0).getStringCellValue(); //put -1 on ob because we created 4 objects ob[0], ob[1], ob[2], ob[3]
				ob[rowNum-1][1] = sheet.getRow(rowNum).getCell(1).getStringCellValue();
				ob[rowNum-1][2] = sheet.getRow(rowNum).getCell(2).getStringCellValue();
				ob[rowNum-1][3] = rowNum;
			}
		return Arrays.asList(ob);
		}
	
		private String username; //class variables are created to store the data that are made when calling the constructor. since the lifetime of the variables in the constructor dies as soon as the constructor is closed.
		private String password;
		private String expected;
		private int rowNum;
		private WebDriver driver;
		
		public ExcelParameterisationTest(String username, String password, String expected, int row) {
			this.username = username;
			this.password = password;
			this.expected = expected;
			this.rowNum = row;
	}
		@Test
		public void login() throws IOException{
			//Constant constant = new Constant(); we dont need this since we have made the URL variable static.
			driver.get(Constant.URL);
			driver.manage().window().maximize();
			// testing logic
			DemoSiteLandingPage user = PageFactory.initElements(driver, DemoSiteLandingPage.class);
			Login login = PageFactory.initElements(driver, Login.class);
			user.createUser(username, password);
			login.login(username, password);
			String actualValue = login.loginStatus();
			
			System.out.println(username + " " + password + " " + expected);
			// grab actual result and insert it into spreadsheet
			System.out.println("actual result needs to be printed in row:" + rowNum);
			
			//Writing
			FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Documents\\Selenium\\Data driven testing\\DemoSiteDDT.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell;
			cell = row.getCell(3);
			if (cell == null) {
				cell = row.createCell(3);
			}
			cell.setCellValue(actualValue);
			
			try {
				assertEquals("Expected and actual values are not equal", expected, actualValue); //assertEquals("error message", expected value, actual value); if this passes then the code will continue running through the try block.
				assertEquals("Login not successful", expected, actualValue);
				cell = row.getCell(4);
				if (cell == null) {
					cell = row.createCell(4);
				}
				cell.setCellValue("PASS");
			}
			catch (AssertionError e) {
				cell = row.getCell(4);
				if (cell == null) {
					cell = row.createCell(4);
				}
				cell.setCellValue("FAIL");
				// write fail to excel sheet
				//Assert.fail(); // Because AssertionError was caught, test no longer fails,
								// therefore we force it to fail after we have written it to excel sheet
			}
			finally{
				FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Documents\\Selenium\\Data driven testing\\DemoSiteDDT.xlsx");

				workbook.write(fileOut);
				fileOut.flush();
				fileOut.close();
				
				workbook.close();
				file.close();	
				
			}
		}
}
	
