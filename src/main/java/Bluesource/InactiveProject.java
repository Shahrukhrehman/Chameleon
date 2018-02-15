package Bluesource;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Button;
import com.orasi.web.webelements.Textbox;
import com.orasi.web.webelements.Webtable;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class InactiveProject {
	
	private OrasiDriver driver = null;
	
	@FindBy(name="project[name]") private Textbox txtProjName;
	@FindBy(name="commit") private Button btnCreateProject;
	@FindBy(name="button") private Button btnAdd;
	@FindBy(css="table.table-bordered.table-condensed.table-hover") private Webtable projTable;
	
	public InactiveProject() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
	}
	
	public void createInactiveProject() {
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		driver.findButton(By.linkText("Projects")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("button")));
		btnAdd.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_project")));
		
		driver.findElement(By.name("project[name]")).click();
		
		txtProjName.set("SecondTestProject");
		Select select = new Select(driver.findElement(By.name("project[status]")));
		select.selectByValue("Inactive");
		btnCreateProject.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
		
		Boolean inactiveHidden;
		
		if (projTable.getRowWithCellText("SecondTestProject") == 0) {
			inactiveHidden = true;
		}
		else {
			inactiveHidden = false;
		}
		
		String message = "Inactive Project is not displayed";
		
		Assert.assertTrue(inactiveHidden, message);
	}
}
