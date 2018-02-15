package shahrukhTest;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import Bluesource.LoginPage;
import Bluesource.NewProject;

public class NewProjectTest extends WebBaseTest {
	
	@Test
	public void addNewProject() {
		
		TestReporter.setDebugLevel(2);
		
		TestReporter.logScenario("Add new project to Bluesource");
		
		setPageURL("https://bluesourcestaging.herokuapp.com");
		
		testStart("New Project Added");
		
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		
		NewProject addNewProject = new NewProject();
		
		addNewProject.createNewProject();
		
	}

}
