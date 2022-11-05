package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements for Login
	@FindBy(xpath = "//div[@class = 'IiD88i _351hSN'][1]/input")
	public WebElement loginInput;

	@FindBy(xpath = "//div[@class = 'IiD88i _351hSN'][2]/input")
	public WebElement passwordInput;

	@FindBy(xpath = "//div[@class='_1D1L_j']/button")
	public WebElement loginButton;

	@FindBy(xpath = "//div[@class='_3OO5Xc']/input")
	public WebElement searchInput;

	@FindBy(id = "")
	public WebElement addButton;

	@FindBy(id = "")
	public WebElement cartButton;

}
