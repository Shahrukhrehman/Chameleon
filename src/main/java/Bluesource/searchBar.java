package Bluesource;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Textbox;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class searchBar {
	
	private OrasiDriver driver = null;
	
	@FindBy(tagName="input") private Textbox txtSearchBar;
	
	public searchBar() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
	}
	
	public void search() {
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("input")));
		
		driver.findElement(By.tagName("input")).click();
		
		txtSearchBar.set("Es123456");
		
		String message = "Successful Search";
		
		Assert.assertTrue((driver.findLink(By.linkText("Es123456")).isDisplayed()), message);
	}
}
