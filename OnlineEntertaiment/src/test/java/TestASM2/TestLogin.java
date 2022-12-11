package TestASM2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {
	public String baseURL = "http://localhost:8080/OnlineEntertaiment/account/sign-in";
	public String exceptedURL = "http://localhost:8080/OnlineEntertaiment/Homepage";
	public String failURL = "http://localhost:8080/OnlineEntertaiment/account/sign-in;jsessionid=9D1C3DA80239390D9EE76EA293D6397D";
	String driverPath = "D:\\Eclipse\\eclipse\\OnlineEntertaiment\\Driver\\chromedriver.exe";
	public WebDriver driver;
	String user_login = "//*[@id=\"username\"]";
	String user_pass = "//*[@id=\"password\"]";
	String submitBtn = "/html/body/section/div/div/div[2]/form/div[3]/button";

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
