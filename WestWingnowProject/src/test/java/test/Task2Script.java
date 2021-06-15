package test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.WestwingnowHomePage;
import pages.WestWingnowLoginPage;


public class Task2Script {
	
	private static WebDriver driver = null;
	private static String emaildId = "tasneemkhadkiwala@gmail.com";
	private static String password = "Tasneem@520";
	private static String searchText = "möbel";
	private static WestwingnowHomePage homePage;
	private static WestWingnowLoginPage loginPage;
	
	public static void main(String[] args) throws InterruptedException{

	}
	

	@Test
	public void Task2Script() throws InterruptedException{
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.westwingnow.de/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
	driver.switchTo().defaultContent();
	
		
	homePage= new WestwingnowHomePage(driver);
	
	//Search "möbel" in the product search
	homePage.productSearch().sendKeys(searchText);;
	homePage.productSearch().sendKeys(Keys.ENTER);
	Thread.sleep(5000);
	System.out.println("Search is successful");
	
	//Switch to the login/registration overlay
	driver.switchTo().window("");	
	loginPage= new WestWingnowLoginPage(driver);
	loginPage.clickLoginHereLink();
	Thread.sleep(5000);
	
	//Login to the account
	loginPage.enterEmailId(emaildId);
	loginPage.enterPassword(password);
	loginPage.clickLoginButton();
	Thread.sleep(3000);
	System.out.println("User is logged in successfully");
	
	//Verify the product listing page displays list of products
	String productCount=homePage.getProductDisplayedCount();
	System.out.println("After successful search the products displayed count is = "+productCount);
	Assert.assertTrue("After search list of products is displayed successfully and the product count = "+productCount+" ", productCount != null);

	//Select WishList icon of the 1st product displayed
	homePage.selectWishlistIconOfNthProduct(1);
	System.out.println("wishlist icon of 1st product is selected");

	//Verify the wishlist icon on the product is filled or not
	String isSelected= homePage.isWishlistIconSelectedForNthProduct(1);
	System.out.println("Verify whether wishlist icon is filled for 1st product: "+isSelected);
	Assert.assertEquals("Wishlist icon is filled for 1st product", "true", isSelected);
	
	//Verify the product is added to the wishlist and the count = 1
	int wishListCount = homePage.getWishlistCount();
	System.out.println("The product count in the wishlist = "+wishListCount);
	Assert.assertEquals("Product count in wishlist is 1", 1, wishListCount);
	
	//Click on the wishlist
	homePage.clickOnWishlist();
	Thread.sleep(3000);
	System.out.println("Navigated to wishlist page");
	
	//Delete the added product or 1st product from the wishlist
	homePage.deleteNthProductFromWishlist(1);
	System.out.println("Product has got deleted succesfully from the wishlist");
	System.out.println("Test completed successfully");
	
	
	Thread.sleep(5000);
	//Commenting the below code for now so that we can view the UI for the deletion success
	//driver.close(); This will close the current browser window
	//driver.quit(); This will quit the selenium session
	
	}

}