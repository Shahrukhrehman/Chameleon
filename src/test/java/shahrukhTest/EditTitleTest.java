package shahrukhTest;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import Bluesource.EditTitle;
import Bluesource.LoginPage; 

public class EditTitleTest extends WebBaseTest{
	@Test
	public void editTitle() {
		
		TestReporter.setDebugLevel(2);
		
		TestReporter.logScenario("Title has been Editted");
		
		setPageURL("https://bluesourcestaging.herokuapp.com");
		
		testStart("Edit Title");
		
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		
		EditTitle editTitle = new EditTitle();
		
		editTitle.editTitle();
		
	}
}
