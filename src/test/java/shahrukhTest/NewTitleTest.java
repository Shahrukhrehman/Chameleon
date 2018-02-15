package shahrukhTest;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;
import Bluesource.LoginPage;
import Bluesource.NewTitle;

public class NewTitleTest extends WebBaseTest {
	@Test
	public void addNewTitle() {
		
		TestReporter.setDebugLevel(2);
		
		TestReporter.logScenario("New Title Created");
		
		setPageURL("https://bluesourcestaging.herokuapp.com");
		
		testStart("New Title Added");
		
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		
		NewTitle createNewTitle = new NewTitle();
		
		createNewTitle.createNewTitle();
		
	}
}
