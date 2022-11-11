package Test_Automation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ReadExcel;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test(dataProvider = "Authentication")
	public void shouldAnswerWithTrue(String username, String password) {
		System.out.println("Username " + username);
		System.out.println("Password " + password);
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ReadExcel.readExcel();
		return (testObjArray);

	}
}
