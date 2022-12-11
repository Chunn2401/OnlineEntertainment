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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestASM2.Log.ChucNangData;
import TestASM2.ultils.ExcelUltils;

public class TestInsertUser {
	private WebDriver driver;
	private final String SRC = ExcelUltils.DATA_SRC + "TEST_CHUCNANG.xlsx";
	private Set<ChucNangData> logs;
	private ChucNangData data;

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

		data = new ChucNangData();
	}

	private void loginAdmin(String userName, String password) {
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/input")).sendKeys(userName);
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/input")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/button")).submit();
	}

	public void insertUser(String userName, String password, String fullname, String email) {
		driver.findElement(By.xpath("/html/body/nav/div/ul/li[4]/a/img")).click();
		driver.findElement(By.xpath("/html/body/nav/div/ul/li[4]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("/html/body/header/nav[1]/div/div/a[4]")).click();
		driver.findElement(By.xpath("/html/body/main/div/section/form/button[4]")).click();
		driver.findElement(By.xpath("/html/body/main/div/section/form/div[1]/input")).sendKeys(userName);
		driver.findElement(By.xpath("/html/body/main/div/section/form/div[2]/input")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/main/div/section/form/div[3]/input")).sendKeys(fullname);
		driver.findElement(By.xpath("/html/body/main/div/section/form/div[4]/input")).sendKeys(email);
		driver.findElement(By.xpath("/html/body/main/div/section/form/div[5]/div[2]/input")).click();
		driver.findElement(By.xpath("/html/body/main/div/section/form/button[1]")).click();
	}
	

	@Test(dataProvider = "InsertData")
	public void multiInsert(String username, String password, String fullname, String email, String expected)
			throws InterruptedException {
		loginAdmin("user1", "123456");
		insertUser(username, password, fullname, email);

		String currentLabel = driver.findElement(By.xpath("/html/body/main/div/section/div")).getText();

		data.setUsername(username);
		data.setPassword(password);
		data.setFullname(fullname);
		data.setEmail(email);
		data.setAction("Test Insert User (authenticate) function");
		data.setLogTime(new Date());
		data.setExpected(expected);
		data.setActual(currentLabel);

		assertEquals(expected, currentLabel);
	}

	@AfterMethod
	public void teadDown(ITestResult result) throws IOException {
		data.setTestMethod(result.getName());
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			data.setStatus("Success");
			break;
		case ITestResult.FAILURE:
			data.setStatus("Failure");
			data.setException(result.getThrowable().getMessage());

			// chi dinh huong dan file luu anh
			String path = ExcelUltils.IMG_SRC + "failure-" + System.currentTimeMillis() + ".png";
			// goi ham chup anh man hinh tu class tien ich
			ExcelUltils.takescreenShot(driver, path);
			// ghi du lieu hinh anh vao workbook
			data.setImage(path);
			break;
		case ITestResult.SKIP:
			data.setStatus("Skip");
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

	@DataProvider(name = "InsertData")
	public Object[][] data() throws IOException {
		// mo file excell de lay du lieu
		XSSFWorkbook workbook = ExcelUltils.getworkbook(SRC);
		// thay doi ten sheet cho phu hop
		XSSFSheet sheet = workbook.getSheet("INSERT-DATA");
		// doc du lieu test
		Object[][] data = ExcelUltils.readSheetData(sheet);

		return data;
	}
}
