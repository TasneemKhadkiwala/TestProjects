package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WestWingnowLoginPage {
	
	WebDriver driver = null;
	
	By loginHereLink = By.xpath("//button[@data-testid='login-button']");
	By emailTextBox = By.name("email");
	By password = By.name("password");
	By loginButton = By.xpath("//button[@data-testid='login_reg_submit_btn']");
	
	
	public WestWingnowLoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickLoginHereLink(){		
		driver.findElement(loginHereLink).click();
	}
	
	public void enterEmailId(String emailId){		
		driver.findElement(emailTextBox).sendKeys(emailId);
	}
	
	public void enterPassword(String password){
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	public void clickLoginButton(){	
		driver.findElement(loginButton).click();
	}	

}
