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
import com.orasi.web.webelements.Webtable;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class NewTitle {
	
	private OrasiDriver driver = null;
	
	@FindBy(name="title[name]") private Textbox txtTitleName;
	@FindBy(name="commit") private Button btnCreateTitle;
	@FindBy(css="table.table-responsive.table-bordered") private Webtable titleTable;
	
	public NewTitle() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
	}
	
	public void createNewTitle() {
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Titles")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
		
		driver.findElement(By.linkText("New Title")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("title[name]")));
		
		txtTitleName.set("MyNewTitle");
		
		btnCreateTitle.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
		
		Boolean titleCreated;
		
		if (titleTable.getRowWithCellText("MyNewTitle") > 0) {
			titleCreated = true;
		}
		else {
			titleCreated = false;
		}
				
		String message = "New Title Created";	
		Assert.assertTrue(titleCreated, message);
	}
}
