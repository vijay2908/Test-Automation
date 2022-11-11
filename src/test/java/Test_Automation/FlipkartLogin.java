package Test_Automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page_object.HomePage;

public class FlipkartLogin {
	public WebDriver driver;
	WebDriverWait wait;
	String url = "https://www.flipkart.com/";

	@BeforeClass
	public void beforeClass() throws IOException {
		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vijay\\git\\Test-Automation\\driver\\chromedriver.exe");
		File f = new File(System.getProperty("user.dir") + "/src/test/java/utilities/configurartion.properties");
		FileInputStream ff = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(ff);
		String browser = prop.getProperty("browser");
		String browser1 = System.getProperty("browser");

//		Actions aa = new Actions(driver);
//		HttpURLConnection httpURLConnect = (HttpURLConnection) u.openConnection();
//		httpURLConnect.setConnectTimeout(5000);
//		httpURLConnect.connect();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN11);
//		driver = new RemoteWebDriver(new URL("http://localhost:4444/"), cap);
		String check = System.getProperty("browser") != null ? browser1 : browser;
//		if (check.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		} else if (check.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		} else {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test(priority = 0)
	@Parameters({ "username", "password" })
	public void login(String username, String password) throws IOException {
		driver.get(url);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (js.executeScript("return document.readyState").equals("complete")) {
			Assert.assertTrue(true);
		}
		HomePage page = new HomePage(driver);
		page.loginInput.sendKeys(username);
		page.passwordInput.sendKeys(password);
		File f = page.loginButton.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("driver/outp.PNG"));
		page.loginButton.click();
		Actions a = new Actions(driver);
		a.scrollByAmount(1000, 0).perform();

	}

	@Test(priority = 1, retryAnalyzer = report_management.Retry.class)
	public void failCase() {
		Assert.assertTrue(false);
	}
}
