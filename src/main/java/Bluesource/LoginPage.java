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

public class LoginPage {
	
	private OrasiDriver driver = null;
	
	@FindBy(id="employee_username") private Textbox txtUsername;
	@FindBy(id="employee_password") private Textbox txtPassword;
	@FindBy(name="commit") private Button btnLogin;
	
	public LoginPage() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
	}
	
	public void login() {
		txtUsername.set("company.admin");
		txtPassword.set("anything");
		btnLogin.click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout")));
		
		String message = "Successful Login";
		
		Assert.assertTrue((driver.findLink(By.linkText("Logout")).isDisplayed()), message);
	}
	
	public void failedLogin() {
		txtUsername.set("company123");
		txtPassword.set("anything");
		btnLogin.click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("close")));
		
		String message = "Unsuccessful Login";
		
		Assert.assertTrue((driver.findLink(By.className("close")).isDisplayed()), message);
	}
	
}
