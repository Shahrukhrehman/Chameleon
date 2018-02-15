package Bluesource;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Button;
import com.orasi.web.webelements.Textbox;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class NewProject {
	
	private OrasiDriver driver = null;
	
	@FindBy(name="project[name]") private Textbox txtProjName;
	@FindBy(name="commit") private Button btnCreateProject;
	@FindBy(name="button") private Button btnAdd;
	
	public NewProject() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
	}
	
	public void createNewProject() {
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		driver.findButton(By.linkText("Projects")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("button")));
		btnAdd.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_project")));
		
		driver.findElement(By.name("project[name]")).click();
		
		txtProjName.set("TestProject");
		btnCreateProject.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("TestProject")));
		
		String message = "Project Added";
		
		Assert.assertTrue((driver.findElement(By.linkText("TestProject")).isDisplayed()), message);
	}
}
