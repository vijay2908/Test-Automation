package Test_Automation;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import page_object.HomePage;

public class FlipkartLogin {
	public WebDriver driver;
	WebDriverWait wait;
	String url = "https://www.flipkart.com/";

	@BeforeClass
	public void beforeClass() {
		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vijay\\git\\Test-Automation\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test(priority = 0)
	@Parameters({ "username", "password" })
	public void login(String username, String password) {
		driver.get(url);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (js.executeScript("return document.readyState").equals("complete")) {
			Assert.assertTrue(true);
		}
		HomePage page = new HomePage(driver);
		page.loginInput.sendKeys(username);
		page.passwordInput.sendKeys(password);
		page.loginButton.click();

	}

	@Test(priority = 1)
	public void failCase() {
		Assert.assertTrue(false);
	}
}
