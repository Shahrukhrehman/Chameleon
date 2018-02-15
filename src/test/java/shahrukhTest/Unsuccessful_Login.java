package shahrukhTest;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import Bluesource.LoginPage;
import Bluesource.WrongLoginPage;

public class Unsuccessful_Login extends WebBaseTest{
	@Test
	public void testUnsuccessfulLogin() {
		
		TestReporter.setDebugLevel(2);
		
		TestReporter.logScenario("Test unsuccessful login to Bluesource");
		
		setPageURL("https://bluesourcestaging.herokuapp.com");
		
		testStart("Unsuccessful Login");
		
		WrongLoginPage unSuccessfulLoginPage = new WrongLoginPage();
		unSuccessfulLoginPage.failedLogin();
		
	}
}
