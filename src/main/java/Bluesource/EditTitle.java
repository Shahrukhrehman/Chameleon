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

public class EditTitle {
	
	private OrasiDriver driver = null;
	
	@FindBy(name="title[name]") private Textbox txtTitleName;
	@FindBy(name="commit") private Button btnCreateTitle;
	@FindBy(css="table.table-responsive.table-bordered") private Webtable titleTable;
	
	public EditTitle() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
	}
	
	public void editTitle() {
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Titles")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
		
		int rowNum = titleTable.getRowWithCellText("MyFirstTitle");
		
		driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr[" + rowNum + "]/td/div/a[1]/span")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("title[name]")));
		
		txtTitleName.set("MyNewFirstTitle");
		
		btnCreateTitle.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
		
		Boolean titleCreated;
		
		if (titleTable.getRowWithCellText("MyNewFirstTitle") > 0) {
			titleCreated = true;
		}

		else {
			titleCreated = false;
		}
				
		String message = "Title has been Editted";	
		Assert.assertTrue(titleCreated, message);
	}
	
}
