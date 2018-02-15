package shahrukhTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import Bluesource.LoginPage;
import Bluesource.searchBar;

public class Successful_Login extends WebBaseTest{
	
	@Test
	public void testSuccessfulLogin() {
		
		TestReporter.setDebugLevel(2);
		
		TestReporter.logScenario("Verify a successful login to Bluesource");
		
		setPageURL("https://bluesourcestaging.herokuapp.com");
		
		testStart("Successful Login");
		
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		
	}
	
}
