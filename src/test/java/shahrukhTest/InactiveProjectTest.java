package shahrukhTest;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import Bluesource.InactiveProject;
import Bluesource.LoginPage;

public class InactiveProjectTest extends WebBaseTest {
	@Test
	public void addNewProject() {
		
		TestReporter.setDebugLevel(2);
		
		TestReporter.logScenario("Inactive projects are not displayed");
		
		setPageURL("https://bluesourcestaging.herokuapp.com");
		
		testStart("New Inactive Project Added");
		
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		
		InactiveProject addInactiveProject = new InactiveProject();
		
		addInactiveProject.createInactiveProject();
		
	}
}
