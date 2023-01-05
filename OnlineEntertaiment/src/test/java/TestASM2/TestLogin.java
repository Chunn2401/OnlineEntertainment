package TestASM2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {
	public String baseURL = "fb.com";
	public String exceptedURL = "";
	public String failURL = "";
	String driverPath = "D:\\Eclipse\\eclipse\\OnlineEntertaiment\\Driver\\chromedriver.exe";
	public WebDriver driver;
	String user_login = "";
	String user_pass = "";
	String submitBtn = "";

	public void login(String userName, String password) {
		driver.findElement(By.xpath(user_login)).sendKeys(userName);
		driver.findElement(By.xpath(user_pass)).sendKeys(password);
		driver.findElement(By.xpath(submitBtn)).click();
	}

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseURL);
	}

	@Test
	public void TC1() {
		login("user2", "123456");
		Assert.assertEquals(driver.getCurrentUrl(), exceptedURL);
	}

	@Test
	public void TC2() {	
		login("1", "1");
		Assert.assertEquals(driver.getTitle(), "SignIn Online Entertainment");
	}

	@AfterMethod
	public void finish() {
//	driver.quit();
	}
}
