package shahrukhTest;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import Bluesource.LoginPage;
import Bluesource.searchBar;

public class testSearchBar extends WebBaseTest{
	@Test
	public void testSearch() {
		
		TestReporter.setDebugLevel(2);
		
		setPageURL("https://bluesourcestaging.herokuapp.com");
		
		testStart("Successful Search");
		
		TestReporter.logScenario("Verify a successful directory search");
		
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		
		searchBar search = new searchBar();
		search.search();
	}
}
