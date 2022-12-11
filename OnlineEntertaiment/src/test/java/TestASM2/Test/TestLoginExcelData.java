package TestASM2.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestASM2.Log.LoginData;
import TestASM2.ultils.ExcelUltils;

public class TestLoginExcelData {
	private WebDriver driver;
	private final String SRC = ExcelUltils.DATA_SRC + "LOGIN_TEST.xlsx";
	private Set<LoginData> logs;
	private LoginData data;

	@BeforeClass
	public void init() throws IOException {
		System.setProperty("webdriver.chrome.driver", ExcelUltils.CHORME_DRIVER_SRC);
		// khoi tao danh sach log
		logs = new LinkedHashSet<>();
	}

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/OnlineEntertaiment/account/sign-in");
//		driver.manage().window().maximize();

		data = new LoginData();
	}

	private void processLogin(String username, String password) {
		WebElement userInput = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/input"));
		userInput.sendKeys(username);
		WebElement passInput = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/input"));
		passInput.sendKeys(password);
		WebElement ClickBtn = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/button"));
		ClickBtn.click();
	}

	@Test(dataProvider = "loginData")
	public void multiLogin(String username, String password, String expected) throws InterruptedException {
		processLogin(username, password);
		String currentTitle = driver.getTitle();

		data.setUsername(username);
		data.setPassword(password);
		data.setAction("Test Login (authenticate) function");
		data.setLogTime(new Date());
		data.setExpected(expected);
		data.setActual(currentTitle);
		assertEquals(expected, currentTitle);
	}

	@AfterMethod
	public void teadDown(ITestResult result) throws IOException {
		data.setTestMethod(result.getName());
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			data.setStatus("PASS");
			break;
		case ITestResult.FAILURE:
			data.setStatus("FAILURE");
			data.setException(result.getThrowable().getMessage());

			// chi dinh huong dan file luu anh
			String path = ExcelUltils.IMG_SRC + "failure-" + System.currentTimeMillis() + ".png";
			// goi ham chup anh man hinh tu class tien ich
			ExcelUltils.takescreenShot(driver, path);
			// ghi du lieu hinh anh vao workbook
			data.setImage(path);
			break;
		case ITestResult.SKIP:
			data.setStatus("SKIP");
			break;
		default:
			break;
		}
		logs.add(data);
		driver.close();
		driver.quit();
	}

	@AfterClass
	public void destroy() throws IOException {
		data.writeLog(SRC, "RESULT-TEST", logs);
	}

	@DataProvider(name = "loginData")
	public Object[][] data() throws IOException {
		// mo file excell de lay du lieu
		XSSFWorkbook workbook = ExcelUltils.getworkbook(SRC);
		// thay doi ten sheet cho phu hop
		XSSFSheet sheet = workbook.getSheet("LOGIN-DATA");
		// doc du lieu test
		Object[][] data = ExcelUltils.readSheetData(sheet);

		return data;
	}
}
