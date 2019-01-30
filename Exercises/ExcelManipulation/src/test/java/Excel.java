import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Excel {
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
	public void loginTest() throws Exception {
		DemoSiteLandingPage user = PageFactory.initElements(driver, DemoSiteLandingPage.class);
		Login login = PageFactory.initElements(driver, Login.class);
		
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Documents\\Selenium\\Data driven testing\\DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String username = "";
		String password = "";
		String expectedValue = "";
		String actualValue = "";

		//Reading
		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
			for (int colNum = 0; colNum < sheet.getRow(rowNum).getPhysicalNumberOfCells(); colNum++) {
				XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
				String userCell = cell.getStringCellValue();
				switch (colNum) {
				case 0:
					username=userCell;
					break;
				case 1:
					password=userCell;
					break;
				case 2:
					expectedValue=userCell;
					break;
				}
				System.out.println(userCell);
			}
			user.createUser(username, password);
			login.login(username, password);
			actualValue = login.loginStatus();
			
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell = row.getCell(3);
			if (cell == null) {
				cell = row.createCell(3);
			}
			cell.setCellValue(actualValue);
			
			XSSFCell cellOfResult = row.getCell(4);
			
			if (expectedValue.equals(actualValue)) {
				if (cellOfResult == null) {
					cellOfResult = row.createCell(4);
				}
				cellOfResult.setCellValue("true");
			}
			else {
				if (cellOfResult == null) {
					cellOfResult = row.createCell(4);
				}
				cellOfResult.setCellValue("false");
			}
			
		
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Documents\\Selenium\\Data driven testing\\DemoSiteDDT.xlsx");

			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			
			file.close();
			
//			assertEquals("Login failed", expectedValue, login.loginStatus());
		}
		
		//Writing
//		XSSFRow row = sheet.getRow(1);
//		XSSFCell cell = row.getCell(6);
//		if (cell == null) {
//			cell = row.createCell(6);
//		}
//		cell.setCellValue("hello");
//		
//	
//		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Documents\\Selenium\\Data driven testing\\DemoSiteDDT.xlsx");
//
//		workbook.write(fileOut);
//		fileOut.flush();
//		fileOut.close();
//		
//		file.close();		
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
